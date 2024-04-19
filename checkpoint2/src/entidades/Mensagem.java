package entidades;

public class Mensagem {
	private String nome;
	private String emailTelefone;
	private int MotivoContato;
	private String mensagem;
	public Mensagem(String nome, String emailTelefone, int motivoContato, String mensagem) {
		super();
		this.nome = nome;
		this.emailTelefone = emailTelefone;
		MotivoContato = motivoContato;
		this.mensagem = mensagem;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmailTelefone() {
		return emailTelefone;
	}
	public void setEmailTelefone(String emailTelefone) {
		this.emailTelefone = emailTelefone;
	}
	public int getMotivoContato() {
		return MotivoContato;
	}
	public void setMotivoContato(int motivoContato) {
		MotivoContato = motivoContato;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
