package curso.grails

class Produto {

    String nome
    Double preco
    Estoque estoque

    static hasMany = [
            clientes:Cliente,
            itens: ItemPedido
    ]

    //indica que eh a classe Cliente quem manda na associacao Produto X Cliente, isso define de que lado serah a
    //cascata ao adicionar e excluir registros no banco, nesca caso eh definido que o lado forte e o Cliente
    static belongsTo = [Cliente]

    static constraints = {
        nome nullable: false, blank: false
        preco min: new Double(0)
    }

    //o bloco mapping permite fazer alteracoes que implicarao no banco de dados, como alterar o nome da tabela e/ou campos
    static mapping = {
        discriminator column: "tipo", value: "GERAL"
        //table name: "tb_produto"//define que a classe de dominio 'Produto' no banco de dados serah a tabela 'tb_produto'
        estoque column: "id_estoque"//define que o nome da propriedade 'estoque' no banco de dados serah 'id_estoque'
        clientes joinTable: [name:"preferencias_clientes", key:"id_produto", column:"id_cliente"]
    }
}
