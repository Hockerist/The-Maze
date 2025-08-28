package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Key_Image extends SuperObject {
     
    // File Path for Key Image.
    // theres two classes of key because the object image is too small to be put in the screen.
    public Key_Image() {

        name = "Key";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/source/objects/KeyImage.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
        
    }
}
