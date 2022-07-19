
public class Main {

    public static void main(String[] args) {
            Portugues pt = new Portugues();
            String falaEducada = "Bom dia, boa noite, boa tarde.";
            pt.setFalaEducada(falaEducada);
            String malEducado = "Palavrões";
            pt.setMalEducado(malEducado);
            
            System.out.println("Pessoa educada fala: "+falaEducada+"\nPessoa mal educada fala: "+malEducado);
        }
        
    }
