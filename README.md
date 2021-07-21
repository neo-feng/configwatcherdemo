# ConfigWatcher

A demo service that utilizes Spring-Cloud-Kubernets-CloudWatcher to get auto updates on Config Map Changes. Config Watcher run in parallel to the demo service and publishes the change event to the services when ever one is detected
Kubernetes resource ConfigMap is utilized in this demo however the same rules applies to Secret as well.

# prepare enveironment
Create a kubernetes cluster, e.g. on EKS
#deploy config watcher
```
kubectl apply -f kubeConfig/config-watcher.yml
```
#b uild docker image
```
mvn clean install
docker build -t demoapp:x.x .
docker tag demoapp:x.x xxx/demoapp:x.x
docker push xxx/demoapp:x.x
```
# deploy configmap
```
kubectl apply -f kubeConfig/configmap.yml
```
# deploy demo application
```
kubectl apply -f kubeConfig/demo-service.yml
```
# watch demo logs
```
kubectl logs -f deploy/demo
```
You should see repeated logs with a specifed number in the config map, e.g. 885.
```
Wed Jul 21 11:35:14 CST 2021: Now processing on Hello World! updated 885
Wed Jul 21 11:35:19 CST 2021: Now processing on Hello World! updated 885
Wed Jul 21 11:35:24 CST 2021: Now processing on Hello World! updated 885
Wed Jul 21 11:35:29 CST 2021: Now processing on Hello World! updated 885
```
# modify configmap and redeploy
Modify the number in configmap, such as 886
```
kubectl apply -f kubeConfig/configmap.yml
```

# watch logs in config watcher and demo
You'll see congfig map modification detected in confg watcher logs
And you'll see number changed to 886 in demo logs

 
