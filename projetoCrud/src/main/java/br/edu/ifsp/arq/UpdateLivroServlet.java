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

@WebServlet({"/editar-livro", "/atualizar-livro"})
public class UpdateLivroServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        int id = request.getParameter("id");
        List<Livro> livros = (List<Livro>) getServletContext().getAttribute("livros");

        Livro livroSelecionado = null;
        
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                livroSelecionado = livro;
                break;
            }
        }

        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html><html><head><title>Editar Livro</title></head><body>");
        out.println("<form action='atualizar-livro' method='POST'>");
        out.println("<input type='hidden' name='id' value='" + livroSelecionado.getId() + "' />");
        out.println("Título: <input type='text' name='titulo' value='" + livroSelecionado.getTitulo() + "' /><br>");
        out.println("Autor: <input type='text' name='autor' value='" + livroSelecionado.getAutor() + "' /><br>");
        out.println("Ano: <input type='number' name='ano' value='" + livroSelecionado.getAno() + "' /><br>");

        String[] generos = {"ficcao", "Nficcao", "fantasia", "romance"};
        for (String genero : generos) {
            boolean checked = livroSelecionado.getGeneros().contains(genero);
            out.println("<input type='checkbox' name='opcao' value='" + genero + "' " + (checked ? "checked" : "") + "> " + genero + "<br>");
        }

        out.println("<button type='submit'>Salvar</button>");
        out.println("</form></body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = request.getParameter("id");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        int ano = request.getParameter("ano");
        String[] generosSelecionados = request.getParameterValues("opcao");

        ArrayList<String> generos = new ArrayList<>();
        
        if (generosSelecionados != null) {
            for (String genero : generosSelecionados) {
                generos.add(genero);
            }
        }

        List<Livro> livros = (List<Livro>) getServletContext().getAttribute("livros");
        
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                livro.setTitulo(titulo);
                livro.setAutor(autor);
                livro.setAno(ano);
                livro.setGeneros(generos);
                break;
            }
        }

        PrintWriter out = resp.getWriter();

        String url = "/listar-livros";
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
