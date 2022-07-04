import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gabri
 */
public class Tabuleiro {
    
    private ArrayList<String> palavras;
    private String palavraDigitada = "";
    private ArrayList<String> palavrasTentadas = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> letrasEstados = new ArrayList<>();
    
    public boolean perdeu = false;
    public boolean ganhou = false;
    
    /*
        estados:
        0 -> errado
        1 -> meio-certo
        2 -> certo
        
        palavra = "ossos"
        
        digitada -> balao
                    00001
        
        palavrasTentadas[0] = "balao"
        letrasEstado[0] = [0,0,0,0,1]
                  
    
    */
    
    public boolean check = false;
    
    public Tabuleiro (ArrayList<String> lista) {
        Collections.shuffle(lista);
        this.palavras = lista;
        
    }
    
    public String remover(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
    
    public void tick() {
        
        String palavraAtual = palavras.get(0);
        
        palavraAtual = remover(palavraAtual);
        
        if (palavrasTentadas.size() == 6)
            perdeu = true;
        
        if (check) {
            check = false;
            
            if (ganhou || perdeu) {
                
                palavraDigitada = "";
                palavrasTentadas = new ArrayList<>();
                letrasEstados = new ArrayList<>();
                perdeu = false;
                ganhou = false;
                palavras.remove(0);
                
            } else {
                if (palavraDigitada.length() == 5) {
                    
                    String palavraDG = palavraDigitada.toUpperCase();
                    ArrayList<Integer> estados = new ArrayList<>();
                    
                    if (palavraDG.equals(palavraAtual)) {

                        System.out.println("ACERTOU");

                        ganhou = true;

                        for(int i = 0; i < 5; i++) {
                            estados.add(2);
                        }


                    } else {


                        char[] ch = new char[5];
                        
                        palavraDG.getChars(0, 5,ch,0);

                        for (int i = 0; i < palavraDG.length(); i++) {
                            if(palavraAtual.contains(String.valueOf(palavraDG.charAt(i)))){

                                if (palavraDG.charAt(i) == palavraAtual.charAt(i)) {
                                    System.out.println("letra: "+palavraDG.charAt(i)+" esta na posição correta");

                                    estados.add(2);
                                } else {

                                    System.out.println("letra: "+palavraDG.charAt(i)+" esta na posição errada");

                                    estados.add(1);

                                }
                            } else {
                                System.out.println("não tem a letra: "+palavraDG.charAt(i)+" nesta palavra");
                                estados.add(0);
                            }

                        }

                        palavrasTentadas.add(palavraDigitada);
                        palavraDigitada = "";
                        System.out.println("ERROU");

                    }
                    
                    letrasEstados.add(estados);
                    System.out.println(letrasEstados);
                
                }
            }
        }
    }
    
    public void apagarUltimo() {
        if (palavraDigitada.length() > 0)
            palavraDigitada = palavraDigitada.substring(0, palavraDigitada.length()-1);
    }
    
    public void setPalavraDigitada(char digitada){
        palavraDigitada += String.valueOf(digitada);
    }
    
    public String getPalavraDigitada(){
        return palavraDigitada;
    }
    
    public void render(Graphics g) {
        
        String palavra = palavras.get(0);
        
        g.setFont(new Font("arial", Font.BOLD, 20));
        
        int k = palavraDigitada.length();
        
        if (!ganhou && !perdeu) {
            if (palavraDigitada.length() != palavra.length()){ 
                g.setColor(new Color(255,255,255));
                g.drawRoundRect(Game.WIDTH/3 +(25*k) + (5*k) -1, 24 + (palavrasTentadas.size()*5) + (25*palavrasTentadas.size()), 27, 27, 10, 10);
            }
        }
        
        
        for (int i = 0; i < palavra.length(); i++) {
            for (int j = 0; j < 6; j++) {
                
                g.setColor(new Color(82, 86, 89, 127));
                g.fillRoundRect(Game.WIDTH/3 +(25*i) + (5*i), 25 + (j*5) + (25*j), 25, 25, 10, 10);
                
                g.setColor(new Color(0,0,0));
                g.drawRoundRect(Game.WIDTH/3 +(25*i) + (5*i), 25 + (j*5) + (25*j), 25, 25, 10, 10);
                
                
            }
            
        }
        
        
        for (int i = 0; i < letrasEstados.size(); i++) {
        
            for (int j = 0; j < 5; j++) {
                
                int mult = letrasEstados.get(i).get(j);
                
                Color c;
                
                switch (mult) {
                    
                    case 0:
                        c = new Color(0, 0, 0 ,0);
                        break;
                       
                    case 1:
                        c = new Color(235, 235, 52 ,127);
                        break;
                        
                    case 2:
                        c = new Color(55, 235, 52 ,127);
                        break;
                    
                    default:
                        c = new Color(0, 0, 0 ,0);   
                }
                
                g.setColor(c);
                g.fillRoundRect(Game.WIDTH/3 +(25*j) + (5*j), 25 + (i*5) + (25*i), 25, 25, 10, 10);
                
                g.setColor(new Color(0,0,0));
                g.drawRoundRect(Game.WIDTH/3 +(25*j) + (5*j), 25 + (i*5) + (25*i), 25, 25, 10, 10);
                
            }
            
            
        }
        
        
        g.setColor(new Color(255,255,255));
        
        for (int i = 0; i < palavraDigitada.length(); i++) {

            if (palavraDigitada.length() > 0)
                g.drawString(String.valueOf(palavraDigitada.charAt(i)).toUpperCase(), 7 + Game.WIDTH/3 +(25*i) + (5*i), 46 + (30*palavrasTentadas.size()));

        }
        
        
        if (ganhou || perdeu){
            
            g.drawString("A palavra era: "+palavra, Game.WIDTH/4 +20, Game.HEIGHT-99);
            g.drawString("Você " + ((perdeu) ? " perdeu " : "") + ((ganhou) ? " ganhou " : "") + " o jogo!!", Game.WIDTH/4 + 20, Game.HEIGHT-65);
            g.drawString("Pressione ENTER para reiniciar", Game.WIDTH/5, Game.HEIGHT-30);


        }
        
        for (int i = 0; i < palavrasTentadas.size(); i++) {
            String palavraTentada = palavrasTentadas.get(i);
            if (palavraTentada.length() > 0)
                for(int j = 0; j < palavraTentada.length(); j++)
                    g.drawString(String.valueOf(palavraTentada.charAt(j)).toUpperCase(), 7 + Game.WIDTH/3 +(25*j) + (5*j), 46 + (i*30));
            
        }
        
        //g.drawString(palavra, Game.WIDTH-100, 50);

        
    }
    
}
