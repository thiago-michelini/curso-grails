<!doctype html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>Controle de Permissões</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <style type="text/css">
        #divUsuarios{
            width: 30%;
            float:left;
            border: 1px solid #000;
            margin: 5px;
        }
        #divPermissoes{
            width: 45%;
            float:right;
            border: 1px solid #fc0;
            margin: 5px;
        }
        #divDetalhesUsuario{
            width: 20%;
            float:left;
            border: 1px solid #000;
            margin: 5px;
        }
        #divFormUsuario, #divFormPermissao{
            padding: 5px;
        }
    </style>
    <script>
        $(document).ready(function(){

        })

        function retornoSalvarUsuario(data) {
            if (data.mensagem == "OK")
                $("#divMensagemUsuario").html("Salvo com sucesso.");
            else
                $("#divMensagemUsuario").html("Não foi possível salvar o usuário");
        }
    </script>
</head>
<body>
    <div id="divUsuarios">
        <div id="divFormUsuario">
            <div id="divMensagemUsuario"></div>
            <g:formRemote id="formUsuario" name="formUsuario" url="[controller: 'controlePermissao', action: 'salvarUsuario']" onSuccess="retornoSalvarUsuario(data)" >
                Login <input type="text" name="login" value="" />
                <!--input type="hidden" name="id" /-->
                <input type="submit" name="salvar" value="Salvar" />
            </g:formRemote>
        </div>
        <table>
            <thead>
                <th>Nome</th>
            </thead>
            <tbody>
                <g:each in="${usuarios}" var="usuario">
                    <tr>
                        <td>${usuario.username}</td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </div>
    <div id="divDetalhesUsuario"></div>
    <div id="divPermissoes">
        <table>
            <thead>
                <th>Permissão</th>
            </thead>
            <tbody>
                <g:each in="${permissoes}" var="permissao">
                    <tr>
                        <td>${permissao.authority}</td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </div>
</body>
</html>
