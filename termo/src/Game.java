import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;


public class Game extends Canvas implements Runnable, KeyListener{

	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private Thread thread;
	private boolean isRunning = true;
	public final static int WIDTH = 480;
	public final static int HEIGHT= 320;
	private final int SCALE = 3;
        public static boolean restart = false;
	
	private BufferedImage image;
        
        public static ArrayList<String> lista = new ArrayList<>();
        public Tabuleiro tabuleiro;
        
	
	public Game() {
		addKeyListener(this);
		setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		initFrame();
		//inicializando objetos
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
                tabuleiro = new Tabuleiro(lista);
	}
        
	public void initFrame() {
		frame = new JFrame("Game#1");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	
	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String[]args) {
            
            Arquivo arquivo = new Arquivo(System.getProperty("user.dir")+"\\src\\dicionario.txt");
            
            lista = arquivo.gerarLista();
            

            Game game = new Game();
            game.start();
            
	}
	
	public void tick() {
            tabuleiro.tick();
            
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = image.getGraphics();
		g.setColor(new Color(49,42,44));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		/*Renderização do jogo */
		//Graphics2D g2 = (Graphics2D) g;
                
		tabuleiro.render(g);
                
		/**/
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image,0,0,WIDTH*SCALE,HEIGHT*SCALE,null);
		bs.show();
	}
	
	public void run(){
		requestFocus();
		long lastTime = System.nanoTime();
		double amoutOfTicks = 60.0;
		double ns = 1000000000/amoutOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		while(isRunning) {
			long now = System.nanoTime();
			delta+= (now - lastTime)/ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}
			if(System.currentTimeMillis() - timer >= 1000) {
				//System.out.println("FPS: "+frames);
				frames = 0;
				timer+=1000;
			}
			
		}
		stop();
		
	}

	public void keyPressed(KeyEvent e) {
            
            
            
            
                
            String tecla = KeyEvent.getKeyText(e.getKeyCode());

            if (tecla.length() == 1) {
                if (tabuleiro.getPalavraDigitada().length() < 5)
                    tabuleiro.setPalavraDigitada(e.getKeyChar());
            }
            
           
	}
	
	public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                tabuleiro.check = true;
            }
            
            else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
               tabuleiro.apagarUltimo();
            } 
	}

        public void keyTyped(KeyEvent e) {
            
	}

	
}


