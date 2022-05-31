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
    public void calcular(int num1, int num2){
        resultado = num1+num2;
    }
    
    public double calcular(double num1, double num2){
        return num1 + num2;
    }
    
}
