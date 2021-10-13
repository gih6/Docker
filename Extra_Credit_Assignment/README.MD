
# Sentiment Analysis

Link to Demo is here: https://pitt.zoom.us/rec/share/Zbib8WgsCpPTLjpLMOJuAR2zjU4_Vk5hKULLLrh4rt1m0zCziy9WflSx8I6P2lMF.rHqiawCtnvJI6U0c?startTime=1634090290000


Also Uploaded to Google Drive here: https://drive.google.com/file/d/1LrKA5N6McUZB46r7nu3zt0SKFWzQ7CkX/view?usp=sharing

### Docker Links are below: 

Frontend: https://hub.docker.com/r/gih6/sentiment-analysis-frontend (Both normal and minikube tag)

Sentimental: https://hub.docker.com/r/gih6/sentiment-analysis-logic 

Web App: https://hub.docker.com/r/gih6/sentiment-analysis-web-app 

### Running on Kubernetes Google Cloud Engine:



### Steps to run Kubernetes on Google Cloud Engine:

First Set up and run a cluster from the GKE (Make sure gcloud was initialized on cloudshell in correct time zone and kubernetes API is enabled)

>$ gcloud container clusters get-credentials cluster-1 --zone us-central-c --project elegant-tide-326122

>$ kubectl create -f service-sa-frontend-lb.yaml

>$ kubectl apply -f sa-frontend-deployment.yaml

>$ kubectl apply -f sa-logic-deployment.yaml --record

>$ kubectl create -f service-sa-logic.yaml --record

>$ kubectl apply -f sa-web-app-deployment.yaml --record

>$ kubectl create -f sa-web-app-deployment.yaml

>$ kubectl create -f service-sa-web-app-lb.yaml

>$kubectl get svc (This is where need to change IP inside APP.js to the sa-web-app-lb

>$ kubectl apply -f sa-frontend-deployment.yaml




