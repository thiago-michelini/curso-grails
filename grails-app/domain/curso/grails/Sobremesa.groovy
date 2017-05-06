package curso.grails

class Sobremesa extends Produto {

    Integer calorias

    static constraints = {
        discriminator value: "SOBREMESA"
        calorias min: 0
    }
}
