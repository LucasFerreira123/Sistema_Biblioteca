import java.time.LocalDate;

public class Professor extends Pessoa {

	private String matricula;

	public Professor(Integer codigo, String nome, String matricula) {
		super(codigo, nome);
		this.matricula = matricula;
	}

	@Override
	public void realizarEmprestimo(Livro livro) {
		if (isUsuarioDevedor()) {
			System.out.println("Usuário não pode realizar o empréstimo. Existe um debito para este usuário.");

		} else {
			Emprestimo novoEmprestimo = new Emprestimo(this, livro, LocalDate.now(), LocalDate.now().plusDays(21),
					true);
			getEmprestimos().add(novoEmprestimo);
		}
	}

	@Override
	public void renovarEmprestimo(Livro livro) {
		boolean achou = false;

		for (Emprestimo emprestimo : getEmprestimos()) {
			if (emprestimo.getLivro().getCodigo() == livro.getCodigo()) {
				emprestimo.setDataEmprestimo(LocalDate.now().plusDays(21));
				achou = true;
			}
		}

		if (!achou)
			System.out.println("Não existe empréstimo do livro para o usuúrio " + getNome() + ".");
	}

	@Override
	public void devolucaoLivro(Livro livro) {
		//TODO Auto-generated method stub

	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Professor [matricula=" + matricula + "]";
	}

}
