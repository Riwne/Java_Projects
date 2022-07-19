public class Professor extends Funcionario implements Autenticavel{
    private int senha = 3333;
    
    public Professor(String nome, int cpf) {
        super(nome, cpf);
    }

    //Verificacao
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
