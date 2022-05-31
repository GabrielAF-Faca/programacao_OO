
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Soma soma = new Soma();
        Subtracao sub = new Subtracao();
        Multiplicacao mult = new Multiplicacao();
        Divisao div = new Divisao();
        
        soma.calcular(getInput("Informe o primeiro número:"), getInput("Informe o segundo número:"));
        showMessage("Soma: " + soma.getResultado());
        
        sub.calcular(getInput("Informe o primeiro número:"), getInput("Informe o segundo número:"));
        showMessage("Subtração: " + sub.getResultado());
        
        mult.calcular(getInput("Informe o primeiro número:"), getInput("Informe o segundo número:"));
        showMessage("Multiplicação: " + mult.getResultado());
        
        div.calcular(getInput("Informe o primeiro número:"), getInput("Informe o segundo número:"));
        showMessage("Divisão: " + div.getResultado());
    }
    
    public static int getInput(String msg){
        return Integer.parseInt(JOptionPane.showInputDialog(msg));
    }

    public static void showMessage(String msg){
        System.out.println(msg);
    }
    
}
