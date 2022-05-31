/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laboratorio
 */
public class Soma extends Calculadora{
    
    @Override
    public void calcular(double num1, double num2){
        resultado = num1+num2;
    }
    
    public double calcular(double num1){
        resultado += num1+100;
        
        return resultado;
    }
    
    public String calcular(String num){
        return Integer.parseInt(num) + 200 + "";
    }
    
    
    
    @Override
    public void exibirResultado(){
        System.out.println(resultado);
    }
}
