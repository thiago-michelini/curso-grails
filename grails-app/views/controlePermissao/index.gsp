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
            carregarListaUsuarios();
            carregarListaPermissoes();
        })

        function carregarListaUsuarios(){
            $.ajax({
                method: "POST",
                url: "listarUsuarios",
                data: { },
                success: function(data){
                    $("#divListaUsuario").html(data)
                }
            })
        }

        function carregarListaPermissoes(){
            $.ajax({
                method: "POST",
                url: "listarPermissoes",
                data: { },
                success: function(data){
                    $("#divListaPermissao").html(data)
                }
            })
        }

        function retornoSalvarPermissao(data){
            if(data.mensagem=="OK"){
                $("#divMensagemPermissao").html("Permissão salva com sucesso.")
                $("#formPermissao input[name=permissao]").val("")
                $("#formPermissao input[name=id]").val("")
                carregarListaPermissoes()
            }else{
                $("#divMensagemPermissao").html("Não foi possível salvar a permissão.")
            }
        }

        function retornoSalvarUsuario(data) {
            if (data.mensagem == "OK") {
                $("#divMensagemUsuario").html("Salvo com sucesso.");
                carregarListaUsuarios();
                $("input[name=login]").val("");
            } else
                $("#divMensagemUsuario").html("Não foi possível salvar o usuário");
        }

        function alterarPermissao(id){
            $.ajax({
                method: "POST",
                url: "getPermissao",
                data: { "id": id },
                success: function(data){
                    $("#formPermissao input[name=permissao]").val(data.authority)
                    $("#formPermissao input[name=id]").val(data.id)
                }
            })
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
        <div id="divListaUsuario"></div>
    </div>
    <div id="divDetalhesUsuario"></div>
    <div id="divPermissoes">
        <div id="divFormPermissao">
            <div id="divMensagemPermissao"></div>
            <g:formRemote id="formPermissao" name="formPermissao" url="[controller: 'controlePermissao', action: 'salvarPermissao']" onSuccess="retornoSalvarPermissao(data)">
                Permissão <input type="text" name="permissao" value="" />
                <input type="hidden" name="id" />
                <input type="submit" name="salvar" value="Salvar" />
            </g:formRemote>
        </div>
        <div id="divListaPermissao"></div>
    </div>
</body>
</html>
