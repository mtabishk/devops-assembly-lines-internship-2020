job("kube1_groovy"){
  description("Seed job1")
  scm{
    github('mtabishk/jenkinsfile-groovy-script','master')
  }
  steps{
    shell('sudo cp -vrf * /jenkins_ws')
  }
  triggers{
    gitHubPushTrigger()
  }
}

job("kube2_groovy"){
  steps{
    shell('''
if sudo ls /jenkins_ws | grep php
then
	if sudo kubectl get pods | grep php-dep
	then
		echo "Already Running"
		sudo kubectl cp /jenkins_ws/*.php $(sudo kubectl get pods -o=jsonpath='{.items[0].metadata.name}'):/var/www/html
    else
        sudo kubectl -k /jenkins_ws/deployp/
        sudo kubectl cp /jenkins_ws/*.php $(sudo kubectl get pods -o=jsonpath='{.items[0].metadata.name}'):/var/www/html
    fi
elif sudo ls /jenkins_ws | grep html
then   
    if sudo kubectl get pods | grep httpd-dep
	then
	    echo "Already Running"
	    sudo kubectl cp /jenkins_ws/*.html $(sudo kubectl get pods -o=jsonpath='{.items[0].metadata.name}'):/usr/local/apache2/htdocs/
    else
        sudo kubectl -k /jenkins_ws/deployp/
        sudo kubectl cp /jenkins_ws/*.html $(sudo kubectl get pods -o=jsonpath='{.items[0].metadata.name}'):/usr/local/apache2/htdocs/
    fi 
else
    echo "File not Found"
fi
	''')
  }
  triggers {
        upstream('kube1_groovy', 'SUCCESS')
  }
}

job("kube3_groovy")
{
  steps{
    shell('''
status=$(curl -o /dev/null -s -w "%{http_code}" http://192.168.99.100:31000/)
if [[ $status == 200 ]]
then
    echo "App is Running fine"
    exit 1
else
     echo "App is not runnnig fine"
     echo 0
fi
     ''')
  }
  
  triggers {
        upstream('kube2_groovy', 'SUCCESS')
  }
}

job("kube4_groovy")
{
  steps{
    shell('''
    echo "App is not working"
    sudo python3 /jenkins_ws/mail_to__dev.py
     ''')
  }
  
  triggers {
        upstream('kube3_groovy', 'SUCCESS')
  }
}

