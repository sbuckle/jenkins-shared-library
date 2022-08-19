package uk.webteq

class PodTemplate {
    
    def getTemplate(Map config) {
        def podYaml = '''
apiVersion: v1
kind: Pod
metadata:
  name: hello-docker
spec:
  containers:<% for ( c in containers ) { %>
  - name: $c.name
    image: $c.image
    tty: $c.tty<% } %>
'''
        def engine = new groovy.text.SimpleTemplateEngine()
        def binding = [
            "containers": config.containers,
            "name": config.get('name', '')
        ]
        def tmpl = engine.createTemplate(podYaml).make(binding)
        return tmpl.toString()
    }
}
