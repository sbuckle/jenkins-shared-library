import uk.webteq.*

def podTemplate() {
  return new DockerPodTemplate().getTemplate()
}

@groovy.transform.Field
def DOCKER = '''
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: docker
    image: docker
    env:
    - name: DOCKER_HOST
      value: tcp://127.0.0.1:2375
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
