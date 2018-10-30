package banco.ui;

import java.util.List;

import banco.dao.AutorDao;
import banco.dao.LivroDao;
import banco.modelo.Autor;
import banco.modelo.Livro;

public class InterfaceLivroTexto extends InterfaceModeloTexto {
	
	private LivroDao dao;
	private AutorDao autorDao;
	
	public InterfaceLivroTexto() {
		super();
		dao = new LivroDao();
		autorDao = new AutorDao();
	}
	
	private Livro obtemDadosLivro(Livro livro) {
		
		System.out.print("Insira o título do livro: ");
		String titulo = entrada.nextLine();
		
		System.out.print("Insira o ano de publicação (somente números): ");
		int anoPublicacao = entrada.nextInt();
		entrada.nextLine();
		
		System.out.print("Insira o nome da editora: ");
		String editora = entrada.nextLine();

		System.out.print("Insira o id do autor: ");
		int autor_id = entrada.nextInt();

		Autor autor = autorDao.getByKey(autor_id);

		Livro novoLivro = new Livro(titulo, anoPublicacao, editora, autor);
		
		return novoLivro;
	}
	
	@Override
	public void adicionar() {
		System.out.println("Adicionar livro");
		System.out.println();
		
		Livro novoLivro = obtemDadosLivro(null);
		dao.insert(novoLivro);
		
	}

	@Override
	public void listarTodos() {
		List<Livro> livros = dao.getAll();
		
		System.out.println("Lista de livros");
		System.out.println();
		
		System.out.println("id\tTítulo\tAno publicação\tEditora\tAutor");

		for (Livro livro : livros) {
			imprimeItem(livro);
		}
		
	}

	@Override
	public void editar() {
		listarTodos();
		
		System.out.println("Editar livro");
		System.out.println();
		
		System.out.print("Entre o id do livro: ");
		int id = entrada.nextInt();
		entrada.nextLine();
		
		Livro livroAModifcar = dao.getByKey(id);
		
		Livro novoLivro = obtemDadosLivro(livroAModifcar);
		
		novoLivro.setId(id);
		
		dao.update(novoLivro);
		
	}

	@Override
	public void excluir() {
		listarTodos();
		
		System.out.println("Excluir livro");
		System.out.println();
		
		System.out.print("Entre o id do livro: ");
		int id = entrada.nextInt();
		entrada.nextLine();
		
		dao.delete(id);
		
	}

}
