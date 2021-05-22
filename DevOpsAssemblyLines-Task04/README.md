# DevOpsAssemblyLines-Task04

## Auto Rolling-update in K8s using Dynamic Jenkins Cluster

### Problem Statement:
1. Create a container image that has Linux and other basic configuration required to run Slave for Jenkins. ( example here we require kubectl to be configured )

2. When we launch the job it should automatically start the job on slave based on the label provided for a dynamic approach.

3. Create a job chain of job1 & job2 using the build pipeline plugin in Jenkins 

4. Job1: Pull the Github repo automatically when some developers push the repo to Github and perform the following operations as:

  1. Create the new image dynamically for the application and copy the application code into that corresponding docker image

  2. Push that image to the docker hub (Public repository) 

 ( Github code contain the application code and Dockerfile to create a new image )

5. Job2 ( Should be run on the dynamic slave of Jenkins configured with Kubernetes kubectl command): Launch the application on the top of Kubernetes cluster performing following operations:

  1. If launching the first time then create a deployment of the pod using the image created in the previous job. Else if deployment already exists then do a rollout of the existing pod making zero downtime for the user.

  2. If Application created the first time, then Expose the application. Else don’t expose it.
  
  ## Solution and Explanation:
  https://www.linkedin.com/pulse/devops-assembly-lines-task-04-auto-rolling-update-k8s-khanday/
