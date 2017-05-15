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