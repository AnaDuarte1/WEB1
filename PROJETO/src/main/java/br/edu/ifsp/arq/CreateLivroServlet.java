package br.edu.ifsp.arq;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/criar-livro")
public class CreateLivroServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        int ano = Integer.parseInt(request.getParameter("ano"));
        String[] generosSelecionados = request.getParameterValues("opcao");

        ArrayList<String> generos = new ArrayList<>();
        
        if (generosSelecionados != null) {
            for (String g : generosSelecionados) {
                generos.add(g);
            }
        }       
        
        Livro novoLivro = new Livro(titulo, autor, ano, generos);

        List<Livro> livros = (List<Livro>) getServletContext().getAttribute("livros");
       
        livros = new ArrayList<>();

        livros.add(novoLivro);

        getServletContext().setAttribute("livros", livros);

        response.sendRedirect("listar-livros");

    }
}
