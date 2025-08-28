package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Diamond_Image extends SuperObject {

    // theres two classes of Diamond because the obj image is too small to be put in the screen.

    public Diamond_Image() {

        name = "Diamond_Image";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/source/objects/diamond_image.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
    
}