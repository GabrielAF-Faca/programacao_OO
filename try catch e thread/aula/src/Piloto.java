
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Azenha Fachim
 */
public class Piloto extends Thread{
    private String nome;

    public Piloto(String nome) {
        this.nome = nome;
    }
    
    @Override
    public void run(){
        System.out.println(nome + " começou a corrida!!!");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Piloto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("\n"+nome + " terminou a corrida!!!");
        
    }
    
}
