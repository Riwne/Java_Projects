
import javax.swing.JOptionPane;

public class TylerTheCreator {
public static void main(String[] args){

StringBuilder mensagem = new StringBuilder();
String message = "Can i get a kiss?" ;
String title = "Can i?";


int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
  if (reply == JOptionPane.YES_OPTION){
    mensagem.append("And can u make it last forever?"); JOptionPane.showMessageDialog(null, mensagem);
   
    JOptionPane.showMessageDialog(null, "I said i'm bout to go to war", " cuidado  u.u ", JOptionPane.WARNING_MESSAGE);

    JOptionPane.showMessageDialog(null, "And i don't know if I'ma see u again :(", " vo chora ", JOptionPane.ERROR_MESSAGE);

    int rep = JOptionPane.showConfirmDialog(null, "Can i get a kiss?","bju", reply);{
        if (rep == JOptionPane.YES_OPTION){
          JOptionPane.showMessageDialog(null, "Te amo <3");}
        if (rep == JOptionPane.NO_OPTION){
          JOptionPane.showMessageDialog(null, "Não merece meu amor :(", " vo chora ", JOptionPane.ERROR_MESSAGE);}
    }
  }
  if (reply == JOptionPane.NO_OPTION){
    JOptionPane.showMessageDialog(null, "Não merece meu amor :(", " vo chora ", JOptionPane.ERROR_MESSAGE);}
  }
}




 
