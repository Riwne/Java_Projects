public class Sistema {
    private int senha;

    public static int quantidade_atual_aluno = 0;
    public static int quantidade_atual_coordenador = 0;
    public static int quantidade_atual_professor = 0;
    public static int quantidade_atual_secretario = 0;
    
    public static final int max_aluno = 10;
    public static final int max_coordenador = 10;
    public static final int max_professor = 10;
    public static final int max_secretario = 10;

    
    Autenticavel autenticacao;
    private Reitor reitor = new Reitor("Reitor", 123456789);
    
    public Reitor getReitor() {
        return reitor;
    }

    public void setReitor(Reitor reitor) {
        this.reitor = reitor;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
    
    public boolean autenticacao(Autenticavel resul) {
        boolean autentica = resul.autentica(this.senha);
        if (autentica == true) {
            System.out.println("Autenticado com sucesso!");
            return true;
        } else {
            System.out.println("Senha errada!");
            return false;
        }
    }

    Coordenador[] coordenador = new Coordenador[max_coordenador];
    Professor[] professor = new Professor[max_professor];
    Secretario[] secretario = new Secretario[max_secretario];

    Aluno[] aluno = new Aluno[max_aluno];
    

    //VERIFICAÇÃO SE AINDA CABE ALUNO E COORDENADOR
    public boolean veri_qtd_aluno(){
        if(quantidade_atual_aluno < max_aluno){
            return true;
        }else{
            return false;
        }
    }
    public boolean veri_qtd_coordenador(){
        if(quantidade_atual_coordenador < max_coordenador){
            return true;
        }else{
            return false;
        }
    }
    public boolean veri_qtd_professor(){
        if(quantidade_atual_professor < max_professor){
            return true;
        }else{
            return false;
        }
    }
    public boolean veri_qtd_secretario(){
        if(quantidade_atual_secretario < max_secretario){
            return true;
        }else{
            return false;
        }
    }
}
