<%@ include file="header.jsp"%>

  <form action="tarefa" method="POST">
        <label for="nome">Nome da Tarefa:</label>
        <input type="text" id="nome" name="nome">

		<br>

        <label for="descricao">Descri��o da Tarefa:</label>
        <textarea id="descricao" name="descricao" rows="3"></textarea>


        <br>

        <button type="submit">Enviar</button>
    </form>
    

<%@ include file="footer.jsp" %>
