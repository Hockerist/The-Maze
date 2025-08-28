package Entity;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.KeyHandler;

public class Player extends Entity {
    
    GamePanel gp;
    KeyHandler keyH;
    int standCounter = 0;
    boolean moving = false;
    int pixelCounter = 0;
    public int hasKey = 0;
    public int hasDiamond = 0;
    public int hasGold= 0;

    public final int screenX, screenY;

    public Player(GamePanel gp, KeyHandler keyH) {
        
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle(1, 1, 46, 46);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 15;
        worldY = gp.tileSize * 2;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try{

            up1 = ImageIO.read(getClass().getResourceAsStream("/source/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/source/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/source/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/source/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/source/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/source/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/source/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/source/player/boy_right_2.png"));
            
        }catch(IOException e) {
        	e.printStackTrace();
        	}
    }

    public void update() {

        if(moving == false) {
            if(keyH.upPressed == true || keyH.downPressed == true
            || keyH.leftPressed == true || keyH.rightPressed == true) {
   
           
           if(keyH.upPressed == true) {
               direction = "up";
   
           }else if(keyH.downPressed == true) {
               direction = "down";
   
           }else if(keyH.leftPressed == true) {
               direction = "left";
   
           }else if(keyH.rightPressed == true) {
               direction = "right";
   
           }

           moving = true;
   
           // CHECK TILE COLLISION
           collisionOn = false;
           gp.cChecker.checkTile(this);

           // CHECK OBJECT COLLISION
           int objIndex = gp.cChecker.checkObject(this, true);
           pickUpObject(objIndex);
   
        }
        else {
            standCounter++;

            if(standCounter == 20) {
                spriteNum = 1;
                standCounter = 0;
            }
        }
    }
    
    if(moving == true) {
        // IF COLLISION IS FALSE, PLAYER CAN MOVE
        if(collisionOn == false) {

            switch(direction) {
                case "up": worldY -= speed; break;
                case "down": worldY += speed; break;
                case "left": worldX -= speed; break;
                case "right": worldX += speed; break;
            }
        }
        spriteCounter++;
        if(spriteCounter > 12) {
            if(spriteNum == 1) {
                spriteNum = 2;
            }
            else if(spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
        pixelCounter += speed;

        if(pixelCounter == 48) {
            moving = false;
            pixelCounter = 0;
        }
    }
}

    public void pickUpObject(int i) {
        if(i != 143) {
            String objectName = gp.obj[i].name;

            switch(objectName) {
                case "Key":
                    gp.playSE(1);
                    hasKey++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("You found a key!");
                    break;
                case "Door":
                    if(hasKey > 0) {
                        gp.playSE(4);
                        hasKey--;
                        gp.obj[i] = null;
                        gp.ui.showMessage("You opened the door!");
                        break;
                    }else {
                        gp.ui.showMessage("You need a key!");
                    }
                    break;
                case "Chest":
                    gp.ui.gameFinished = true;
                    gp.stopMusic();
                    gp.playSE(2);
                    break;
                case "Diamond":
                    gp.playSE(1);
                    hasDiamond++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("You found a Diamond!");
                    break;
                case "Gold":
                    gp.playSE(1);
                    hasGold++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("You found a Gold!");
                    break;
            }
        }
    }

    public void draw(Graphics g2) {
       
        BufferedImage image = null;

        switch(direction) {
        case "up":
            image = spriteNum == 1 ? up1: up2;
            break;
        case "down":
            image = spriteNum == 1 ? down1: down2;
            break;
        case "left":
            image = spriteNum == 1 ? left1: left2;
            break;
        case "right":
            image = spriteNum == 1 ? right1: right2;
            break;
        }

         g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}


