import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {

	private int codigo;

	private String nome;

	private List<Emprestimo> emprestimos = new ArrayList<>();

	public Pessoa(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public abstract void realizarEmprestimo(Livro livro);

	public abstract void devolucaoLivro(Livro livro);

	public abstract void renovarEmprestimo(Livro livro);
	
	public boolean isEmprestimoAndamento(int codigoLivro) {
		for (Emprestimo emprestimo : getEmprestimos()) {
			if (emprestimo.isAtivo())
				return true;
		}
		return false;
	}
	
	public boolean isLimiteEmprestimoAtivo(int limite) {
		int qtd = 0;

		for (Emprestimo emprestimo : getEmprestimos()) {
			if (emprestimo.isAtivo())
				qtd++;
		}

		if (qtd == limite)
			return true;
		else
			return false;
	}

	public boolean isUsuarioDevedor() {

		for (Emprestimo emprestimo : getEmprestimos()) {
			if (emprestimo.isAtivo()) {

				Period period = Period.between(emprestimo.getDataParaEntrega(), LocalDate.now());

				if (period.getDays() > 0)
					return true;
			}
		}
		return false;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nome=" + nome + "]";
	}

}
