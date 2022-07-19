public class Reitor extends Funcionario implements Autenticavel{
    private int senha = 1234;
    
    public Reitor(String nome, int cpf) {
        super(nome, cpf);
    }

    public int mostrarSenha() {
        return this.senha;
    }
    
    public void setSenha(int senha) {
        this.senha = senha;
    }

    public boolean autentica(int senha) {
        if (senha == this.senha){
            return true;
        }else{
            return false;
        }
    }
    
}