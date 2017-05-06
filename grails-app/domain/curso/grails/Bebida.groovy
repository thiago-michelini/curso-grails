package curso.grails

class Bebida extends Produto {

    Double liquido
    String unidade

    static constraints = {
        discriminator value: "BEBIDA"
        liquido min: new Double(0)
        unidade nullable: false, blank: false, inList: ["L","ml"]
    }
}
