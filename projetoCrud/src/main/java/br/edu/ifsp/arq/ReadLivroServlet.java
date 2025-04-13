package br.edu.ifsp.arq;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listar-livros")
public class ReadLivroServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        List<Livro> livros = (List<Livro>) getServletContext().getAttribute("livros");

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Lista de Livros</title></head><body>");
        out.println("<h1>Livros Cadastrados</h1>");

        out.println("<table border='1'>");
        out.println("<tr><th>Título</th><th>Autor</th><th>Ações</th></tr>");

            for (Livro livro : livros) {
                out.println("<tr>");
                out.println("<td>" + livro.getTitulo() + "</td>");
                out.println("<td>" + livro.getAutor() + "</td>");
                out.println("<td>");
                out.println("<a href='editar-livro?id=" + livro.getId() + "'>Editar</a> | ");
                out.println("<a href='excluir-livro?id=" + livro.getId() + "'>Excluir</a>");
                out.println("</td></tr>");
            }

        out.println("</table>");
        out.println("<br><a href='form-livro.html'>Adicionar Novo Livro</a>");
        out.println("</body></html>");
    }
}
