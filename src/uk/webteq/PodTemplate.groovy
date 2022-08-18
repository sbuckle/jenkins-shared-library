package uk.webteq

class PodTemplate {
    
    def getTemplate(Map config) {
        def podYaml = '''
apiVersion: v1
kind: Pod
spec:
  containers:<% for ( c in $containers ) { %>
  - name: $c.name
    image: $c.image<% } %>
'''
        def engine = new groovy.text.SimpleTemplateEngine()
        def binding = [
            "containers": config.containers
        ]
        def tmpl = engine.createTemplate(podYaml).make(binding)
        return tmpl.toString()
    }
}
