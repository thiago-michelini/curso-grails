package curso.grails

class Cliente {

    String nome
    String email
    String senha
    String cpf

    static hasMany = [
            pedidos:Pedido,
            produtosPreferidos:Produto
    ]

    static constraints = {
        nome nullable: false, blank: false
        email email: true, unique: true//unique define que não pode haver mais de um cliente com o mesmo email no BD
        senha size: 6..10
        //validator permite fazer uma validacao customizada com closure
        cpf validator: {valor, objeto ->
            (valor.size() == 11)
        }
    }

    static mapping = {
        /*define que o campo produtosPreferidos serah uma tabela de juncao no banco de dados chamada 'preferencias_clientes'
        name: nome da tabela
        key: coluna que representa a classe Cliente na tabela 'preferencias_clientes'
        column: coluna que representa a classe Produto na tabela 'preferencias_clientes'*/
        produtosPreferidos joinTable: [name:"preferencias_clientes", key:"id_cliente", column:"id_produto"]
    }
}
