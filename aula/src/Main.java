
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author laboratorio
 */
public class Main {

    public static void main(String[] args) {
        
        /*
        String frase = null;
        String novaFrase = null;

        try {
            novaFrase = frase.toUpperCase();
            
        } catch (NullPointerException e) {
            System.out.println("Frase inicial nula, valor default atribuído");
            frase = "frase vazia";
            
        } finally {
            System.out.println("Dentro do finally");
            novaFrase = frase.toUpperCase();
            
        }
        
        System.out.println("Frase antiga: " + frase);
        System.out.println("Frase nova: " + novaFrase);

        */

        /*
        try {
            aumentarLetras();
        } catch (Exception e) {
            
            System.out.println(
                    
                "Ao executar o método aumentarLetras(),"
                + " ocorreu o seguinte erro:\n" + e
                    
            );
        }
        */
        String frase = getFrase("Informe uma frase");
        
        frase = testarFrase(frase);
         
        System.out.println(frase);
    }
    
    public static String testarFrase(String frase) {
        try {

            checaLetraB(frase);


        } catch (semLetraBException e) {
            
            System.out.println("Ao checar pela letra b,"
                    + " ocorreu o seguinte erro:\n" + e);

            frase = getFrase("Informe uma frase");
                
            frase = testarFrase(frase);

        }
        
        return frase;
    }
    
    public static String getFrase(String msg) {
        return JOptionPane.showInputDialog(msg);
    }

    private static boolean checaLetraB(String frase) throws semLetraBException{

        if (!frase.contains("b") && !frase.contains("B")) {
            
            throw new semLetraBException();

        } else {
            
            return true;
        
        }
    }

    private static void aumentarLetras() throws Exception {

        String frase = null;
        String novaFrase = null;

        try {
            novaFrase = frase.toUpperCase();

        } catch (NullPointerException e) {
            throw new Exception(e);

        }

        System.out.println("Frase antiga: " + frase);
        System.out.println("Frase nova: " + novaFrase);

    }

}
