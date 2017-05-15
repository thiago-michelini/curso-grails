package restaurantetocomfome

import comum.Permissao
import comum.Usuario
import grails.converters.JSON

class ControlePermissaoController {

    def index() {
        render(view: "index")
    }

    def listarPermissoes() {
        def listaPermissoes = Permissao.list()
        render(template: "listaPermissoes", model: [permissoes: listaPermissoes])
    }

    def listarUsuarios() {
        def listaUsuarios = Usuario.createCriteria().list {
            order("username")
        }
        render(template: "listaUsuarios", model: [usuarios: listaUsuarios])
    }

    def getPermissao(){
        Permissao permissao = Permissao.get(params.id)
        render permissao as JSON
    }

    def salvarPermissao(){
        def retorno = [:]
        Permissao permissao
        if (params.id){
            permissao = Permissao.get(params.id)
        }else{
            permissao=new Permissao()
        }
        permissao.authority = params.permissao
        permissao.validate()
        if (!permissao.hasErrors()){
            permissao.save(flush:true)
            retorno["mensagem"]="OK"
        }else{
            retorno["mensagem"]="ERRO"
        }
        render retorno as JSON
    }

    def salvarUsuario() {
        def retorno = [:]

        Usuario u = new Usuario(
                username: params.login,
                enabled: true,
                passwordExpired: false,
                accountExpired: false,
                accountLocked: false,
                password: "1234"
        )

        u.validate()
        if (!u.hasErrors()) {
            u.save(flush: true)
            retorno["mensagem"] = "OK"
        } else {
            retorno["mensagem"] = "ERRO"
        }

        render retorno as JSON
    }
}
