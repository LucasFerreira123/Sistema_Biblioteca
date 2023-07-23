import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Executar {

	static List<Pessoa> usuarios = new ArrayList<>();
	static List<Livro> livros = new ArrayList<>();

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao;

		do {
			System.out.println("\n------MENU PRINCIPAL------");
			System.out.println("==========================");
			System.out.println("= 1- Cadastrar Aluno     =");
			System.out.println("= 2- Cadastrar Professor =");
			System.out.println("= 3- Cadastrar Livro     =");
			System.out.println("= 4- Realizar Emprestimo =");
			System.out.println("= 0- Sair                =");
			System.out.println("==========================");

			System.out.print("\nInforme a opção: ");
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("\nCadastrar Aluno");
				cadastrarAluno();
				break;
			case 2:
				System.out.println("\nCadastrar Professor");
				cadastrarProfessor();
				break;
			case 3:
				System.out.println("\nCadastrar Livro");
				cadastrarLivro();
				break;
			case 4:
				System.out.println("\nRealizar Emprestimo");
				realizarEmprestimo();
				break;
			case 0:
				System.out.println("Sistema encerrado.");
				break;
			default:
				System.out.println("Opção inválida.");
			}

		} while (opcao != 0);
	}

	private static void realizarEmprestimo() {

		System.out.print("Informe o código do aluno: ");
		int codigoUsuario = scanner.nextInt();

		System.out.print("Informe o código do livro: ");
		int codigoLivro = scanner.nextInt();

		Pessoa usuario = getUsuarioPorCodigo(codigoUsuario);
		Livro livro = getLivroCodigo(codigoLivro);

		if (usuario != null && livro != null) {

			// validar se o livro está disponivel
			if (livro.isDisponivel()) {

				// realizar emprestimo do livro
				if (usuario instanceof Aluno) {
					Aluno aluno = (Aluno) usuario;
					aluno.realizarEmprestimo(livro);
				} else if (usuario instanceof Professor) {
					Professor professor = (Professor) usuario;
					professor.realizarEmprestimo(livro);
				}

				System.out.println("Empréstimo do livro " + livro.getTitulo() + " realizado com sucesso para o "
						+ usuario.getNome());
			} else {
				System.out.println("Livro indisponivel");
			}
		} else {
			System.out.println("Usuário ou Livro não existem!");
		}

	}

	private static void cadastrarAluno() {

		System.out.print("Informe o código do aluno: ");
		int codigo = Integer.parseInt(scanner.next());

		System.out.print("Informe o nome do aluno: ");
		String nome = scanner.next();

		if (!isUsuarioExiste(codigo)) {
			usuarios.add(new Aluno(codigo, nome));
			System.out.println("Usuário cadastrado com sucesso!");
		} else {
			System.out.println("Usuário já cadastrado para o código informado!");
		}

	}

	private static void cadastrarProfessor() {

		System.out.print("Informe o código do professor: ");
		int codigo = Integer.parseInt(scanner.next());

		System.out.print("Informe o nome do professor: ");
		String nome = scanner.next();

		System.out.print("Informe a matrícula do professor: ");
		String matricula = scanner.next();

		if (!isUsuarioExiste(codigo)) {
			usuarios.add(new Professor(codigo, nome, matricula));
			System.out.println("Usuário cadastrado com sucesso!");
		} else {
			System.out.println("Usuário já cadastrado para o código informado!");
		}

	}

	private static void cadastrarLivro() {

		System.out.print("Informe o código do livro: ");
		int codigo = Integer.parseInt(scanner.next());

		System.out.print("Informe o título: ");
		String titulo = scanner.next();

		System.out.print("Informe a editora: ");
		String editora = scanner.next();

		System.out.print("Informe os autores: ");
		String autores = scanner.next();

		System.out.print("Informe a edição: ");
		String edicao = scanner.next();

		System.out.print("Informe o ano de publicação: ");
		int ano = scanner.nextInt();

		if (!isLivroExiste(codigo)) {
			livros.add(new Livro(codigo, titulo, editora, autores, edicao, ano, Boolean.TRUE));
			System.out.println("Livro cadastrado com sucesso!");
		} else {
			System.out.println("Livro já cadastrado para o código informado!");
		}

	}

	private static boolean isUsuarioExiste(int codigo) {
		for (Pessoa usuario : usuarios) {
			if (usuario.getCodigo() == codigo)
				return true;
		}
		return false;
	}

	private static boolean isLivroExiste(int codigo) {
		for (Livro livro : livros) {
			if (livro.getCodigo() == codigo)
				return true;
		}
		return false;
	}

	private static Pessoa getUsuarioPorCodigo(int codigo) {
		for (Pessoa usuario : usuarios) {
			if (usuario.getCodigo() == codigo)
				return usuario;
		}
		return null;
	}

	private static Livro getLivroCodigo(Integer codigo) {

		for (Livro livro : livros) {
			if (livro.getCodigo() == codigo)
				return livro;
		}

		return null;
	}

}
