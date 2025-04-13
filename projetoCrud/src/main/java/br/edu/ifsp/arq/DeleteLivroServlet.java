package br.edu.ifsp.arq;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/excluir-livro")
public class DeleteLivroServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = request.getParameter("id");
        List<Livro> livros = (List<Livro>) getServletContext().getAttribute("livros");

        if (livros != null) {
        	 for (int i = 0; i < livros.size(); i++) {
                 if (livros.get(i).getId() == id) {
                     livros.remove(i);
                     break;
                 }
             }
        }

        PrintWriter out = resp.getWriter();

        String url = "/listar-livros";
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
