package uk.webteq

class DockerPodTemplate {
    
    def getTemplate() {
        return '''
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: docker
    image: docker
    env:
    - name: DOCKER_HOST
      value: tcp://localhost:2375
    tty: true
  - name: dind
    image: docker:19.03.0-dind
    env:
    - name: DOCKER_TLS_CERTDIR
      value: ""
    securityContext:
      privileged: true
    volumeMounts:
    - name: dind-storage
      mountPath: /var/lib/docker
  volumes:
  - name: dind-storage
    emptyDir: {}
'''
    }
}

public class ContainerDefinition {
  String name, image

  ContainerDefinition(name, image) {
    this.name = name
	  this.image = image
  }
}
