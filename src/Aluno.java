import java.time.LocalDate;

public class Aluno extends Pessoa {

	/**
	 * @param codigo
	 * @param nome
	 */
	public Aluno(Integer codigo, String nome) {
		super(codigo, nome);
	}

	@Override
	public void realizarEmprestimo(Livro livro) {

		if (isUsuarioDevedor()) {
			System.out.println("Usuário não pode realizar o empréstimo. Existe um debito para este usuário.");
			
		} else if (isLimiteEmprestimoAtivo(3)) {
			System.out.println("Usuário chegou ao limite de livros.");
			
		} else if(isEmprestimoAndamento(livro.getCodigo())) {
			System.out.println("Usuário já está com o livro emprestado.");
			
		} else {
			livro.setDisponivel(false);
			Emprestimo novoEmprestimo = new Emprestimo(this, livro, LocalDate.now(), LocalDate.now().plusDays(5), true);
			getEmprestimos().add(novoEmprestimo);
		}

	}

	@Override
	public void devolucaoLivro(Livro livro) {
		//TODO Auto-generated method stub

	}

	@Override
	public void renovarEmprestimo(Livro livro) {
		boolean achou = false;

		for (Emprestimo emprestimo : getEmprestimos()) {
			if (emprestimo.getLivro().getCodigo() == livro.getCodigo()) {
				emprestimo.setDataEmprestimo(LocalDate.now().plusDays(5));
				achou = true;
			}
		}
		
		if (!achou)
			System.out.println("Não existe empréstimo do livro para o usuário " + getNome() + ".");		
	}

}

