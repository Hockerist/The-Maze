package Environtment;

import java.awt.Graphics2D;

import Main.GamePanel;

public class EnvironmentManager {

    GamePanel gp;
    Lightning lightning;

    public EnvironmentManager(GamePanel gp) {

        this.gp = gp;
    }

    public void setUp() {

        lightning = new Lightning(gp, 300);

    }

    public void draw(Graphics2D g2) {
        
        if(lightning != null) {
            lightning.draw(g2);
        }
    }
}
