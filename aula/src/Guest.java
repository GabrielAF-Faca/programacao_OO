
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
public class Guest implements User{

    
    
    public static void main(String[] args){
        Guest guest = new Guest();
        
        if (guest.isAuthorized(JOptionPane.showInputDialog("Informe a senha"))){
            System.out.println("Welcome");
        } else {
            System.out.println("Try again");
        }
    }
            
            
    @Override
    public boolean isAuthorized(String word) {
        
        if((word.toLowerCase()).equals("we are atos")){
            return true;
        }
        
        return false;
    }
    
}
