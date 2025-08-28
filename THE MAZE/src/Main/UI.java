package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import Object.Diamond_Image;
import Object.Gold_Image;
import Object.Key_Image;

public class UI {
    
    GamePanel gp;
    Font arial_40, arial_80B;
    public BufferedImage keyImage, diamondImage, goldImage;
    public boolean messageOn = false;
    public String message = " ";
    int messageCounter;
    public int goldCounter = 0;

    public boolean gameFinished = false;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    double playTime;

    public UI(GamePanel gp) {
        this.gp= gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);

        Key_Image key = new Key_Image();
        keyImage = key.image;
        
        Diamond_Image diamond = new Diamond_Image();
        diamondImage = diamond.image;

        Gold_Image gold = new Gold_Image();
        goldImage = gold.image;
    }

    public void showMessage(String text) {

        message = text;
        messageOn = true;
    }
    public void draw(Graphics2D g2) {
        
        if(gameFinished == true) {

            g2.setFont(arial_40);
            g2.setColor(Color.white);

            String text;
            int textLength;
            int x;
            int y;

            text = "You found the Treasure!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

             x = gp.screenWidth/2 - textLength/2;
             y = gp.screenHeight/2 - (gp.tileSize*3);

             g2.drawString(text, x, y);

            int totalSeconds = (int) playTime;  
            int minutes = totalSeconds / 60;
            int seconds = totalSeconds % 60;
            double milliseconds = (playTime - totalSeconds) * 100;

             x = gp.screenWidth/2 - textLength/2;
             y = gp.screenHeight/2 + (gp.tileSize*4);
             
             if(minutes > 0) {
                String timeDisplay = String.format("Your Time is: %d:%02d", minutes, seconds);
                g2.drawString(timeDisplay, x, y);
             }else if(seconds > 0 && minutes == 0) {
                String timeDisplay = String.format("Your Time is: %02d.%02ds", seconds, (int) milliseconds);
                g2.drawString(timeDisplay, x, y);
             }

             g2.setFont(arial_80B);
             g2.setColor(Color.yellow);

             text = "Congratulation!";
             textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

             x = gp.screenWidth/2 - textLength/2;
             y = gp.screenHeight/2 + (gp.tileSize*2);

             g2.drawString(text, x, y);

             g2.setFont(arial_80B);
             g2.setColor(Color.white);

             text = "Thanks For Playing!";
             textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

             x = gp.screenWidth/2 - textLength/2;
             y = gp.screenHeight/2 - (gp.tileSize*5);

             g2.drawString(text, x, y);
             
             g2.setFont(arial_40);
             g2.setColor(Color.cyan);

             int centerX = gp.screenWidth/2;
             int centerY = gp.screenHeight/2;

             int imageY = centerY - (gp.tileSize/2);

             int diamondX = centerX - (gp.tileSize *4);
             g2.drawImage(diamondImage, diamondX, imageY, gp.tileSize, gp.tileSize, null);
             g2.drawString("x " + gp.player.hasDiamond, diamondX, imageY);
            
             g2.setColor(Color.yellow);
             
             int goldX = centerX - (gp.tileSize * -3);
             g2.drawImage(goldImage, goldX, imageY, gp.tileSize, gp.tileSize, null);
             g2.drawString("x " + gp.player.hasGold, goldX, imageY);

             gp.gameThread = null;


        }else {
            // Key UI
            g2.setFont(arial_40);
            g2.setColor(Color.yellow);
            g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
            g2.drawString("x " + gp.player.hasKey, 75, 60);
            
            // Gold UI
            g2.setFont(arial_40);
            g2.setColor(Color.yellow);
            g2.drawImage(goldImage, gp.tileSize/2, gp.tileSize/2 * 7, gp.tileSize, gp.tileSize, null);
            g2.drawString("x " + gp.player.hasGold, 75, 200);

            // Diamond UI
            g2.setFont(arial_40);
            g2.setColor(Color.cyan);
            g2.drawImage(diamondImage, gp.tileSize/2, gp.tileSize/2 * 4, gp.tileSize, gp.tileSize, null);
            g2.drawString("x " + gp.player.hasDiamond, 75, 130);
            
            // TIME
            g2.setColor(Color.red);
            playTime +=(double)1/60;
            
            int totalSeconds = (int) playTime;  
            int minutes = totalSeconds / 60;
            int seconds = totalSeconds % 60;
            double milliseconds = (playTime - totalSeconds) * 100;

            if(seconds > 0 && minutes == 0) {
                String timeDisplay = String.format("Time: %02d.%02ds", seconds, (int) milliseconds);
                g2.drawString(timeDisplay, gp.tileSize* 26, 60);
            }else if(minutes > 0) {
                String timeDisplay = String.format("Time: %d:%02d.%02ds", minutes, seconds, (int) milliseconds);
                g2.drawString(timeDisplay, gp.tileSize* 26, 60);
            }

            // MESSAGE
            if(messageOn == true) {
                
                if(gp.player.hasGold > 0 || gp.player.hasDiamond > 0 || gp.player.hasKey > 0) {
                    g2.setColor(Color.white);
                }

                g2.setFont(g2.getFont().deriveFont(25F));
                g2.drawString(message, gp.tileSize/2 * 27 + 1, gp.tileSize*15);
                
                messageCounter++;
    
                if(messageCounter > 120) {
                    messageCounter = 0;
                    messageOn = false;
                } 
            }
        }
    }
}
