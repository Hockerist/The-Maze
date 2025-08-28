package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Gold_Image extends SuperObject {

    // theres two classes of Gold because the object image is too small to be put in the screen.

    public Gold_Image() {

        name = "Gold_Image";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/source/objects/gold_image.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
    
}
