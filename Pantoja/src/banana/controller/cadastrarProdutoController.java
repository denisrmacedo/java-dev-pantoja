package banana.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banana.model.Produto;

/**
 * Servlet implementation class cadastrarProdutoController
 */
@WebServlet("/cadastrarProdutoController")
public class cadastrarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadastrarProdutoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("RECEBI A REQUISIÇÃO GET ");
		
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		String descricao = request.getParameter("descricao");
		String mensagem;
		Produto produto = new Produto();
		
		if(descricao != null && !descricao.isEmpty() && request.getParameter("quantidade") != null 
			&& !request.getParameter("quantidade").isEmpty() 
			&& request.getParameter("preco") != null && !request.getParameter("preco").isEmpty()) {
				int quantidade;
				double preco;
				quantidade = Integer.parseInt(request.getParameter("quantidade"));
				preco = Double.parseDouble(request.getParameter("preco"));
				
//				System.out.println("[BANANA]" + descricao);
//				System.out.println("[BANANA]" + quantidade);
//				System.out.println("[BANANA]" + preco);
				
				boolean online = false; 
				if (request.getParameter("online") != null && request.getParameter("online").contentEquals("on")){
					online = true;
				};
				
//				produto.setDescricao(descricao);
//				produto.setQuantidade(quantidade);
//				produto.setPreco(preco);
//				produto.setOnLine(online);
				produto.salvar();
//				System.out.println("[BANANA]" + online );
				
				mensagem = "Produto Cadastrado com sucesso!";
				
				request.setAttribute("mensagem", mensagem);
				RequestDispatcher dispatcher =  request.getRequestDispatcher("cadastrarProduto.jsp"); 
				dispatcher.forward(request, response);
					
			} else {
				mensagem = "Os campos precisam ser preenchidos!";				
				request.setAttribute("mensagem", mensagem);
				RequestDispatcher dispatcher =  request.getRequestDispatcher("cadastrarProduto.jsp"); 
				dispatcher.forward(request, response);
			}
		

//		System.out.println("RECEBI A REQUISIÇÃO POST ");
		
			
		}
		
	}
