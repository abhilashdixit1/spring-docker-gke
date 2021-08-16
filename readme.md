# Steps tp deploy springboot application on GKE

1. Create docker file

2. Build image from dockerfile ( command "docker build -t spring-docker-gke .")

3. Test docker image locally (command "docker run -it --rm -p 8080:8080 spring-docker-gke")

   use http://localhost:8080/hello in browser or postman and vrify if it returns the response
   
4. Create a new project in CGP and enable billing. (https://console.cloud.google.com/home/dashboard) 

4. Enable Container registy API in your GCP project.

5. Login to gcloud cell . command "gcloud auth login"

6. Set the correct project. in cmd navigate to root directory of your project and set the GCP project

   command "gcloud config set project spring-docker-gke"  -->gcloud config set project <project id>

7. Push the docker image to container Registry
   
   To push the Docker image to the Google Container Registry, we have to tag it according to the following pattern reginalEcrHostname/projectId/dockerImageName:tag
   
   command "docker tag spring-docker-gke asia.gcr.io/spring-docker-gke/spring-docker-gke"
   
   verify if the new image with tagged name is created
   
   command to see all the images "docker images"
   
   Now Push the docker image to conatiner registry 
   
   command "docker push asia.gcr.io/spring-docker-gke/spring-docker-gke"
   docker push <region>.gcr.io/<projectId>/<custom image name>
   
8. Create Kubernetes cluster in CGP

   To create the cluster first you need to enable Kubernetes engine Api from GCP dashboard.
   
   Then create a cluster
   
   command "gcloud container clusters create spring-docker-gke-cluster --num-nodes=3 --region=asia-southeast1-a"
   cluster name nodes and region can be chnaged as per need
   
9. configure the cluster for you project

   comamnd "gcloud config set container/cluster spring-docker-gke-cluster"
   
   Deploy your image to created cluster
   
   command "kubectl run spring-docker-gke --image=asia.gcr.io/spring-docker-gke/spring-docker-gke --port 8080"
   
   check pods 
   
   command "kubectl get pods"
   
   Expose your pod
   
   command "kubectl expose pod spring-docker-gke --type=LoadBalancer --port 80 --target-port 8080"
   
   Check services 
   
   command "kubectl get service"
   
   Wait for external API to show up for your service
   
10. Use external ip with your enpoint to test application in Browser or postman.
   
 


