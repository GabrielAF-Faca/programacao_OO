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
//        soma.calcular(2,3);
//        soma.exibirResultado();
//        
//        Multiplicacao mult = new Multiplicacao();
//        mult.calcular(2, 3);
//        mult.exibirResultado();
        
        soma.calcular(2);
        soma.exibirResultado();
        
        System.out.println(soma.calcular("50"));
    }
    
}
