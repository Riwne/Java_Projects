import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
            Scanner leitura = new Scanner(System.in);
            Sistema sistema = new Sistema();

            boolean autenticado_professor = false;
            boolean autenticado_coordenador = false;
            boolean autenticado_reitor = false;

            while(true){  
                int entrada = -1;
                System.out.println("[0] - Autenticar reitor");
                System.out.println("[1] - Autenticar coordenador");
                System.out.println("[2] - Autenticar professor");

                System.out.println("[3] - Cadastrar Coordenador");
                System.out.println("[4] - Cadastrar Professor");
                System.out.println("[5] - Cadastrar Secretario");
                System.out.println("[6] - Cadastrar Aluno");

                System.out.println("[7] - Mostrar Reitor");
                System.out.println("[8] - Mostrar Coordenadores");
                System.out.println("[9] - Mostrar Professores");
                System.out.println("[10] - Mostrar Secretarios");
                System.out.println("[11] - Mostrar Alunos");

                System.out.println("[12] - Alterar Nota do aluno");
                
                try{
                    entrada = leitura.nextInt();
                }catch(Exception erro){
                    System.out.println("!!Digite apenas numeros!!");
                }
                leitura.nextLine();                     

                switch(entrada){
                    case 0: // AUTENTICAR REITOR
                        int senha;
                        System.out.println("senha do reitor: ");
                        senha = leitura.nextInt();
                        sistema.setSenha(senha);
                        autenticado_reitor = sistema.autenticacao(sistema.getReitor());
                    break;
                    case 1: // AUTENTICAR COORDENADOR
                        if(Sistema.quantidade_atual_coordenador > 0){
                            System.out.println("senha do coordenador: ");
                            senha = leitura.nextInt();
                            sistema.setSenha(senha);
                            for (int i = 0; i < Sistema.quantidade_atual_coordenador; i++) {
                                autenticado_coordenador = sistema.autenticacao(sistema.coordenador[i]);
                                if (autenticado_coordenador == true) {  break; }
                            }
                        }else{
                            System.out.println("Não existe coordenador cadastrado");
                        }
                    break;
                    case 2: // AUTENTICAR PROFESSOR
                        if(Sistema.quantidade_atual_professor > 0){
                            System.out.println("senha do professor: ");
                            senha = leitura.nextInt();
                            sistema.setSenha(senha);

                            for (int i = 0; i < Sistema.quantidade_atual_professor; i++) {
                                autenticado_professor = sistema.autenticacao(sistema.professor[i]);
                                if (autenticado_professor == true) {  break; }
                            }
                        }else{
                            System.out.println("Não existe professor cadastrado");
                        }
                    break;
                    case 3: // CAD COORDENADOR
                        if (sistema.veri_qtd_coordenador()){
                            if(autenticado_reitor == true){
                                String nome;
                                int cpf;

                                System.out.println("Nome do Coordenador: ");
                                nome = leitura.next();
                                leitura.nextLine();                     

                                System.out.println("CPF do Coordenador: ");
                                cpf = leitura.nextInt();

                                sistema.coordenador[Sistema.quantidade_atual_coordenador] = new Coordenador(nome, cpf);
                                Sistema.quantidade_atual_coordenador += 1;
                            }else{
                                System.out.println("!!Reitor precisa se autenticar!!");
                            }
                        }else{
                            System.out.println("!!Quantidade de coordenadores excedida!!");
                        }
                    break;
                    case 4: // CAD PROFESSOR
                        if (sistema.veri_qtd_professor()){
                            if(autenticado_reitor == true){
                                String nome;
                                int cpf;

                                System.out.println("Nome do Professor: ");
                                nome = leitura.next();
                                System.out.println("CPF do Professor: ");
                                cpf = leitura.nextInt();

                                sistema.professor[Sistema.quantidade_atual_professor] = new Professor(nome, cpf);
                                Sistema.quantidade_atual_professor += 1;
                            }else{
                                System.out.println("!!Reitor precisa se autenticar!!");
                            }
                        }else{
                            System.out.println("!!Quantidade de coordenadores excedida!!");
                        }    
                    break;
                    case 5: // CAD SECRETARIO
                        if (sistema.veri_qtd_secretario()){
                            if(autenticado_reitor == true){
                                String nome;
                                int cpf;

                                System.out.println("Nome do Secretario: ");
                                nome = leitura.next();
                                leitura.nextLine();                     
                                System.out.println("CPF do Secretario: ");
                                cpf = leitura.nextInt();

                                sistema.secretario[Sistema.quantidade_atual_secretario] = new Secretario(nome, cpf);
                                Sistema.quantidade_atual_secretario += 1;
                            }else{
                                System.out.println("!!Reitor precisa se autenticar!!");
                            }
                        }else{
                            System.out.println("!!Quantidade de coordenadores excedida!!");
                        }
                    case 6: // CAD ALUNO
                        if(sistema.veri_qtd_aluno()){
                            if (autenticado_coordenador == true){ // autenticação de COORDENADOR
                                String nome;
                                int matricula;
                                double nota;
                                
                                System.out.println("Nome do Aluno(a): ");
                                nome = leitura.next();
                                leitura.nextLine();                     
                                System.out.println("Matricula do Aluno(a): ");
                                matricula = leitura.nextInt();
                                System.out.println("Nota do Aluno(a)(use 'virgula'): ");
                                nota = leitura.nextDouble();

                                sistema.aluno[Sistema.quantidade_atual_aluno] = new Aluno(nome, matricula, nota);
                                Sistema.quantidade_atual_aluno += 1;
                            }else{
                                System.out.println("!!Coordenador precisa se autenticar!!");
                            }
                        }else{
                            System.out.println("!!Quantidade de alunos excedida!!");
                        }
                    break;
                    case 7: // MOSTRAR REITOR
                        Reitor reitor = sistema.getReitor();
                        System.out.println("REITOR CADASTRADOS:\n");
                        System.out.println("Reitor: "+reitor.getNome()+"\nCPF: "+reitor.getCpf());
                    break;
                    case 8: // MOSTRAR COORDENADORES
                        if(Sistema.quantidade_atual_coordenador > 0){
                            System.out.println("COORDENADORES CADASTRADOS:\n");
                            for(int i = 0; i < Sistema.quantidade_atual_coordenador; i++){
                                System.out.println("Coordenador: "+sistema.coordenador[i].getNome()+"\nCPF: "+sistema.coordenador[i].getCpf());
                                System.out.println("---------------------------");
                            }
                        }else{
                            System.out.println("Não existe coordenador cadastrado");
                        }
                    break;
                    case 9: // MOSTRAR PROFESSORES
                        if (Sistema.quantidade_atual_professor > 0){
                            System.out.println("PROFESSORES CADASTRADOS:\n");
                            for(int i = 0; i < Sistema.quantidade_atual_professor; i++){
                                System.out.println("Professor: "+sistema.professor[i].getNome()+"\nCPF: "+sistema.professor[i].getCpf());
                                System.out.println("---------------------------");
                            }
                        }else{
                            System.out.println("Não exite professor cadastrado");
                        }
                        
                    break;
                    case 10: // MOSTRAR SECRETARIO
                        if (Sistema.quantidade_atual_secretario > 0){
                            System.out.println("SECRETARIO CADASTRADOS:\n");
                            for(int i = 0; i < Sistema.quantidade_atual_secretario; i++){
                                System.out.println("Secretario: "+sistema.secretario[i].getNome()+"\nCPF: "+sistema.secretario[i].getCpf());
                                System.out.println("---------------------------");
                            }
                        }else{
                            System.out.println("Não exite secretario cadastrado");

                        }
                       
                    break;
                    case 11: // MOSTRAR ALUNO
                        if (Sistema.quantidade_atual_aluno > 0){
                            System.out.println("ALUNO CADASTRADOS:\n");
                            for(int i = 0; i < Sistema.quantidade_atual_aluno; i++){
                                System.out.println("Aluno: "+sistema.aluno[i].getNome());
                                System.out.println("Matricula: "+sistema.aluno[i].getMatricula());
                                System.out.println("Nota: "+sistema.aluno[i].getNota());

                                System.out.println("---------------------------");
                            }
                        }else{
                            System.out.println("Não exite aluno cadastrado");
                        }
                    break;
                    case 12: // AUTERAR NOTA DO ALUNO
                        if (autenticado_professor == true){
                            int matricula_entrada;
                            boolean encontrou = false;

                            System.out.println("Qual a matricula do aluno\n");
                            matricula_entrada = leitura.nextInt();

                            for(int i = 0; i < Sistema.quantidade_atual_aluno; i++){
                                if(matricula_entrada == sistema.aluno[i].getMatricula()){
                                    double nota;

                                    System.out.println("Aluno encontrado: \n");
                                    System.out.println("Nome: "+sistema.aluno[i].getNome());
                                    System.out.println("Nota: "+sistema.aluno[i].getNota());
                                    System.out.println("Digite a nova nota: ");
                                    nota = leitura.nextDouble();

                                    sistema.aluno[i].setNota(nota);

                                    System.out.println("Aluno auterado com sucesso: \n");
                                    System.out.println("Nome: "+sistema.aluno[i].getNome());
                                    System.out.println("Nota: "+sistema.aluno[i].getNota());
                                    encontrou = true;
                                    break;
                                }
                            }

                            if(encontrou == true){
                            }else{
                                System.out.println("Aluno não cadastrado!");
                            }

                        }else{
                            System.out.println("Professor não autenticado!!");
                        }
                    break;
                    
                    default:
                        System.out.println("Digite uma das opcoes!");
                    break;
                }
            }
        
    }
}
