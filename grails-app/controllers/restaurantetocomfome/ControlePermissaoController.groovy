package restaurantetocomfome

import comum.Permissao
import comum.Usuario
import grails.converters.JSON

class ControlePermissaoController {

    def index() {
        def listaUsuarios = Usuario.list()
        def listaPermissoes = Permissao.list()
        render(view: "index", model: [usuarios: listaUsuarios, permissoes: listaPermissoes])
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
