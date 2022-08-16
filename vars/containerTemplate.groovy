import uk.webteq.*

def call(Map m) {
    return new ContainerDefinition(m.name, m.image)
}
