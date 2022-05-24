
/**
 *
 * @author laboratorio
 */
public class Main{

    
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(UI.getValue("Informe seu nome"),Integer.parseInt(UI.getValue("Informe sua idade:")));
        
        pessoa.andar();
        pessoa.falar();
    }
    
}
