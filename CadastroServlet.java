package br.com.turma.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat; //import do sdf
import java.util.Date; //import do date

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.turma.modelo.Usuario;

@WebServlet ("/cadastro")
public class CadastroServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("txtnome");
		Date dataNascimento = request.getParameter("txtdatadenascimento"); //alterado de String para Date
		String login = request.getParameter("txtlogin");
		String senha = request.getParameter("txtsenha");
		
		Usuario usuario = new Usuario();
		
		PrintWriter out = response.getWriter();
		out.println("Nome: "+ nome);
		out.println("Data de Nascimento: "+ dataNascimento);
		out.println("Login: "+ login);
		out.println("Senha: "+ senha);
		
		
	}
	
	//adicionado as linhas abaixo, método de conversão da string da data para data mesmo.
	private Date converterParaDate(String dataComoString) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dataFormatada = sdf.parse(dataComoString);
		
		return dataFormatada;
	}
	
}

