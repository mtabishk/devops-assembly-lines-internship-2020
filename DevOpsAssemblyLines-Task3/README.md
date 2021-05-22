# DevOpsAssemblyLines-Task3

## Managing and Deploying Webserver/App using Jenkins and Kubernetes

### Problem Statement:
(Perform the second task of DevOps Assembly Lines) on top of Kubernetes where we use Kubernetes resources like Pods, ReplicaSet, Deployment, PVC and Service.

1. Create container image that’s has Jenkins installed using Dockerfile Or You can use the Jenkins Server on RHEL 8/7

2. When we launch this image, it should automatically start the Jenkins service in the container.

3. Create a job chain of job1, job2, job3 and job4 using build pipeline plugin in Jenkins 

 Job 1: Pull the Github repo automatically when some developers push the repository to Github.

 Job2: 
   1. By looking at the code or program file, Jenkins should automatically start the respective language interpreter installed image container to deploy code on top of Kubernetes      (   eg. If code is of PHP, then Jenkins should start the container that has PHP already installed )

   2. Expose your pod so that testing team could perform the testing on the pod

   3. Make the data to remain persistent ( If server collects some data like logs, other user information )

Job3 : Test your app if it is working or not.
Job4: if the app is not working, then send email to the developer with error messages and redeploy the application after code is being edited by the developer

## Solution and Explanation:
https://www.linkedin.com/pulse/devops-assembly-lines-task-03-managing-deploying-using-khanday/
