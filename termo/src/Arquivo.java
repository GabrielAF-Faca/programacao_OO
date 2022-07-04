
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Arquivo {
    
    private static String dir;
    
    public Arquivo (String dir) {
        
        this.dir = dir;
        
    }
   
    public ArrayList<String> gerarLista() {
        String fileName = dir;
        
        ArrayList<String> palavras = new ArrayList<>();
        
        Path path = Paths.get(fileName);

        try (FileReader fr = new FileReader(fileName, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(fr)) {

            String str;
            while ((str = reader.readLine()) != null) {
                if (str.length() == 5)
                    palavras.add(str.toUpperCase());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return palavras;
    }
    
   
}
