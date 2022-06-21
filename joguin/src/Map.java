
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laboratorio
 */
public class Map {
    //map width = 15
    //map height = 8
    private int WIDTH;
    private int HEIGHT;
    
    private String mapa[][];
    
    public Map() {
        this.WIDTH = 15;
        this.HEIGHT = 9;
        
        gerarMapa();
    }
    
    public Map(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        
        gerarMapa();
    }
    
    private void gerarMapa() {
        Random rand = new Random();
        mapa = new String[WIDTH][HEIGHT];
        
        int quantidade = rand.nextInt((WIDTH*HEIGHT)/4);
        
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                mapa[i][j] = "#";
            }
        }
        
        for (int i = 1; i < WIDTH-1; i++) {
            for (int j = 1; j < HEIGHT-1; j++) {
                mapa[i][j] = ".";
            }
        }
        
        for(int i = 0; i < quantidade; i++)
            mapa[rand.nextInt(1+WIDTH-2)][rand.nextInt(1+HEIGHT-2)] = "#";
        
        
    }
    
    public void tick() {
        
    }
    
    public void render(Graphics g) {
        Font fonte = new Font("Verdana", Font.BOLD, 10);
        g.setColor(new Color(255, 255, 255));
        g.setFont(fonte);
        
        int sep = fonte.getSize();
        
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                
                g.drawString(mapa[i][j], 10+(i*sep), 10+(j*sep));
                
            }
        }
        
        
    }
}
