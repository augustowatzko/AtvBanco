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
	
	private Autor obtemDadosAutor(Autor autor) {
		
		System.out.print("Insira o nome: ");
		String nome = entrada.nextLine();
				
		System.out.println("Insira o CPF: ");
		long cpf = entrada.nextLong();
		entrada.nextLine();
				
		Autor novoAutor = new Autor(0, nome, cpf);
		
		return novoAutor;
	}
	
	@Override
	public void adicionar() {
		System.out.println("Adicionar");
		System.out.println();
		
		Autor novoAutor = obtemDadosAutor(null);	
		dao.insert(novoAutor);
		
	}

	@Override
	public void listarTodos() {
		List<Autor> autores = dao.getAll();
		
		System.out.println("Lista");
		System.out.println();
		
		System.out.println("id\tNome\tCPF");
		
		for (Autor autor : autores) {
			imprimeItem(autor);
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
		
		Autor autorAModifcar = dao.getByKey(id);
		
		Autor novoAutor = obtemDadosAutor(autorAModifcar);
		
		novoAutor.setId(id);
		
		dao.update(novoAutor);
		
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
