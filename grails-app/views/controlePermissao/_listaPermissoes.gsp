<table>
    <thead>
        <th colspan="2">Permissão</th>
    </thead>
    <tbody>
        <g:each in="${permissoes}" var="permissao">
            <tr>
                <td>${permissao.authority}</td>
                <td><a href="javascript: alterarPermissao(${permissao.id})">Alterar</a></td>
            </tr>
        </g:each>
    </tbody>
</table>