import javax.swing.JOptionPane;

/**
 *
 * @author laboratorio
 */
public class UI {
    
    public static void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static void showMsg(String msg, String title){
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.DEFAULT_OPTION);
    }
    
    public static String getInput(String msg){
        return JOptionPane.showInputDialog(msg);
    }
    
    public static String getInput(String msg, String title){
        return JOptionPane.showInputDialog(null, msg, title, JOptionPane.DEFAULT_OPTION);
    }
    
    public static int getInputInt(String msg){
        return Integer.parseInt(getInput(msg));
    }
    
    public static int getInputInt(String msg, String title){
        return Integer.parseInt(getInput(msg, title));
    }
    
}


