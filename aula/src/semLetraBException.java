/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laboratorio
 */
public class semLetraBException extends Exception{
    
    
    
    @Override
    public String getMessage() {
        return "Não existe letra b ou B em sua frase";
    }
    
}
