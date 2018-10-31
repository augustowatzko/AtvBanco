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
	
	@Override
	public void adicionar() {
		System.out.println("Adicionar");
		System.out.println();
		Livro novoLivro = obtemDadosLivro(null);	
		dao.insert(novoLivro);
	}

	private Livro obtemDadosLivro(Livro livro) {
		System.out.print("Informe o titulo: ");
		String titulo = entrada.nextLine();
		System.out.print("Informe a editora: ");
		String editora = entrada.nextLine();
		System.out.print("Informe o ano: ");
		int anoPublicacao = entrada.nextInt();
		System.out.print("Informe o ID: ");
		int idAutor = entrada.nextInt();
		Autor autor = autorDao.getByKey(idAutor);
		return new Livro(0, titulo, anoPublicacao, editora, autor);
	}

	@Override
	public void listarTodos() {
		List<Livro> livros = dao.getAll();
		System.out.println("Lista");
		System.out.println();
		System.out.println("id\tTitulo\tAno\teditora\tID\tNome");	
		for (Livro livro : livros) {
			imprimeItem(livro);
		}
	}

	@Override
	public void editar() {
		listarTodos();		
		System.out.println("Editar");
		System.out.println();		
		System.out.print("Informe o ID: ");
		int id = entrada.nextInt();
		entrada.nextLine();
		Livro livroAModificar = dao.getByKey(id);
		Livro novoLivro = obtemDadosLivro(livroAModificar);
		novoLivro.setId(id);
		dao.update(novoLivro);
	}

	
	
	@Override
	public void excluir() {
		listarTodos();	
		System.out.println("Excluir");
		System.out.println();
		System.out.print("Informe o ID: ");
		int id = entrada.nextInt();
		entrada.nextLine();	
		dao.delete(id);
	}

}
