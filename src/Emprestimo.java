import java.time.LocalDate;

public class Emprestimo {

	private Pessoa usuario;

	private Livro livro;

	private LocalDate dataEmprestimo;

	private LocalDate dataParaEntrega;

	private boolean ativo;

	public Emprestimo() {
		super();
	}

	public Emprestimo(Pessoa usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataParaEntrega, boolean ativo) {
		super();
		this.usuario = usuario;
		this.livro = livro;
		this.dataEmprestimo = dataEmprestimo;
		this.dataParaEntrega = dataParaEntrega;
		this.ativo = ativo;
	}

	public Pessoa getUsuario() {
		return usuario;
	}

	public void setUsuario(Pessoa usuario) {
		this.usuario = usuario;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataParaEntrega() {
		return dataParaEntrega;
	}

	public void setDataParaEntrega(LocalDate dataParaEntrega) {
		this.dataParaEntrega = dataParaEntrega;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Emprestimo [usuario=" + usuario + ", exemplar=" + livro + ", dataEmprestimo=" + dataEmprestimo + "]";
	}

}

