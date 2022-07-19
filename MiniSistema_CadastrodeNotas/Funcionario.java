public abstract class Funcionario {
    private String nome;
	private int cpf;
    private int senha;
	
	public Funcionario(String nome, int cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	//NOME
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	//CPF
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
    //SENHA 
	public int getSenha() {
        return senha;
    }
    public void setSenha(int senha) {
        this.senha = senha;
    }

}
