package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Entity.Player;
import Environtment.EnvironmentManager;
import Object.SuperObject;
import Tile.TileManager;   

public class GamePanel extends JPanel implements Runnable{

	//Screen Settings
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 3;
	public final int tileSize = originalTileSize * scale; // 48x48 tile
	public final int maxScreenCol = 32;
	public final int maxScreenRow = 20;
	public final int screenWidth = tileSize * maxScreenCol; // 1,536 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 960 pixels
    
    // World Settings
    public final int maxWorldCol = 32;
    public final int maxWorldRow = 32;
    
    //FPS
	int FPS = 60;

    // Instantiation
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Sound music = new Sound();
    Sound se = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);  
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    EnvironmentManager eManager = new EnvironmentManager(this);
    Thread gameThread;

    // ENTITY & OBJECT
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[50];

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
        this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
        this.setFocusable(true);
	}
	
    public void setUpGame() {

        aSetter.setObject();
        eManager.setUp();
        playMusic(0);
    }

	public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
	
	public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            

            if(delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    } 
	
	public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        
        // TILE
        tileM.draw(g2);

        // OBJECT
        for(int i = 0; i<obj.length; i++) {
            if(obj[i] != null) {
                obj[i].draw(this, g2);
            }
        }

        // ENVIRONMENT
        if(eManager != null) {
            eManager.draw(g2);
        }
        
        // PLAYER
        player.draw(g2);

        // UI
        ui.draw(g2);
        
        g2.dispose();
    } 

    public void playMusic(int i) {

        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic() {

        music.stop();
    }

    public void playSE(int i) {
        
        se.setFile(i);
        se.play();
    } 
}


	
