package curso.grails

class Estoque {

    Integer quantidade
    Integer quantidadeMinima
    Produto produto

    static belongsTo = [Produto]

    static constraints = {
        quantidade min: 0
        quantidadeMinima min: 0
        produto nullable: true
    }

    static mapping = {
        produto column: "id_produto"//define que o nome da propriedade 'produto' no banco de dados serah 'id_produto'
    }
}
