package banco.ui;

import java.util.List;

import banco.dao.AutorDao;
import banco.modelo.Autor;

public class InterfaceAutorTexto extends InterfaceModeloTexto {

	private AutorDao dao;
	
	public InterfaceAutorTexto() {
		super();
		dao = new AutorDao();
	}
	
	@Override
	public void adicionar() {
		System.out.println("Adicionar autor");
		System.out.println();
		
		Autor novoAutor = obtemDadosAutor(null);
		dao.insert(novoAutor);
	}

	private Autor obtemDadosAutor(Autor autor) {
		
		System.out.print("Insira o nome: ");
		String nome = entrada.nextLine();
		
		System.out.print("Insira o CPF: ");
		long cpf = entrada.nextLong();

		return new Autor(nome, cpf);
	}

	@Override
	public void listarTodos() {
		List<Autor> autores = dao.getAll();
		
		System.out.println("Lista de autores");
		System.out.println();
		
		System.out.println("id\tNome\tCPF");
		
		for (Autor autor : autores) {
			imprimeItem(autor);
		}
	}

	@Override
	public void editar() {
		listarTodos();
		
		System.out.println("Editar autor");
		System.out.println();
		
		System.out.print("Entre o id da autor: ");
		int id = entrada.nextInt();
		entrada.nextLine();
		
		Autor autorAModificar = dao.getByKey(id);
		
		Autor novoAutor = obtemDadosAutor(autorAModificar);
		
		novoAutor.setId(id);
		
		dao.update(novoAutor);
	}

	@Override
	public void excluir() {
		listarTodos();
		
		System.out.println("Excluir autor");
		System.out.println();
		
		System.out.print("Entre o id da autor: ");
		int id = entrada.nextInt();
		entrada.nextLine();
		
		dao.delete(id);
	}

}
