package br.edu.ifsp.arq.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

import br.edu.ifsp.arq.model.Tarefa;

public class TarefaDAO {
	
	private static TarefaDAO instance;
	
	private TarefaDAO() {
	}
	
	public static TarefaDAO getInstance() {
		
		if(instance == null) {
			instance = new TarefaDAO();
		}
		
		return instance;
	}
	
	public boolean adicionarTarefa(Tarefa t) {
		
		Gson gson = new Gson();
		
		
		try {
			FileWriter fw = new FileWriter("/home/aluno/Downloads/saida.csv", StandardCharsets.UTF_8, true);
			PrintWriter pw = new PrintWriter(fw);
			fw.write("Ola");
			fw.close();
		}catch(IOException e){
			e.printStackTrace();
			return false;
		}
		
		return true;

	}

	public ArrayList<Tarefa> getTarefas(){
		File f = new File("/home/aluno/Downloads/saida.csv");
		List<Tarefa> lista = null;
		String json = gson.toJson();
		System.out.println(json);
		try {		
			FileReader fr = new FileReader(f);
			Scanner sc = new Scanner(fr);
			lista = new ArrayList<Tarefa>();
			while(sc.hasNextLine()) {
				String linha = sc.nextLine();
				String campos[] = linha.split(";");
				Tarefa t = new Tarefa(Integer.parseInt(campos[0]),campos[1], campos[2]);
				System.out.println(linha);
				lista.add(t);
			}
			
			fr.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
		
		return (ArrayList<Tarefa>) lista;
	}
	
}
