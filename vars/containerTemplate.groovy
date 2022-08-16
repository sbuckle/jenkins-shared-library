import uk.webteq.ContainerDefinition

def call(Map m) {
    return new ContainerDefinition(m.name, m.image)
}
