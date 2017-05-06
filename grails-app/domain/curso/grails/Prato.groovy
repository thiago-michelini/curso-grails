package curso.grails

class Prato extends Produto {

    Integer quantidadePessoas

    static constraints = {
        discriminator value: "PRATO"
        quantidadePessoas min: 1
    }
}
