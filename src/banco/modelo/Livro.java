package banco.modelo;

public class Livro implements Imprimivel {
	private int id;
	private String titulo;
	private int anoPublicacao;
	private String editora;
	private Autor autor;

	public Livro() {

	}
	public Livro(String titulo, int anoPublicacao, String editora, Autor autor) {
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
		this.editora = editora;
		this.autor = autor;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Titulo: " + getTitulo()
				+ "\nAno de publicacao: " + String.valueOf(getAnoPublicacao())
				+ "\nEditora: "
				+ getEditora()
				.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})",
						"$1.$2.$3-$4")
				+ "\nAutor: "
				+ getAutor();
	}


	@Override
	public String imprimeEmLista() {
		return String.format("%d\t%s\t%d\t%s\t%s", getId(), getTitulo(), getAnoPublicacao(), getEditora(), getAutor().getNome());
	}

	@Override
	public String[] getColunas() {
		return new String[0];
	}
}
