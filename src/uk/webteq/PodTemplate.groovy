public class PodTemplate {
    
    static String DOCKER_BUILD_TEMPLATE
        = getDockerPodTemplate()

    static String getDockerPodTemplate() {
        return '''
apiVersion: 1.0
kind: Pod
spec:
  containers:
  - name: docker
    image: docker
    env:
    - name: DOCKER_HOST
      value: tcp://locahost:2375
    tty: true
  - name: dind
    image: docker:dind
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