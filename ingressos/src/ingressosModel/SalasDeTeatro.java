package ingressosModel;

public class SalasDeTeatro {
	
	private String email;
	private String senha;
	private String cnpj;
	private String nome;
	private String cidade;
	
	public SalasDeTeatro() {

	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;

	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public String getCidade() {
		return cidade;
	}


}
