/**
 *
 * @author Gabriel Azenha Fachim
 */
public class Main {
    
    static int i = 0;

    public static void main(String[] args) {
        System.out.println("");
        
        Piloto piloto1 = new Piloto("Alisson");
        Piloto piloto2 = new Piloto("Felipe");
        Piloto piloto3 = new Piloto("Tiago");
        
        System.out.println("Foi dada a largada");
        
        piloto1.start();
        piloto2.start();
        piloto3.start();
        
        String frase = null, novaFrase = null;
        try {
            novaFrase = frase.toUpperCase();
        } catch (NullPointerException e) {
            frase = "null";
            novaFrase = frase.toUpperCase();
        }
        
        System.out.println("Frase: "+novaFrase);
        
    }
    
}
