/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laboratorio
 */
public class SerHumano extends Animal{
    protected static String nome;
    protected static int idade;
    
    public static void falar(){
        UI.showMsg("Você falou: '"+UI.getValue("Informe o que você deseja falar:")+"'");
    }
}
