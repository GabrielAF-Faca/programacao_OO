
import javax.swing.JOptionPane;

/**
 *
 * @author laboratorio
 */
public class UI {
    
    public static void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static String getValue(String msg){
        return JOptionPane.showInputDialog(msg);
    }
    
}
