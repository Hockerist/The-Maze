package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Chest extends SuperObject {

        // File Path for Chest Object.

        public OBJ_Chest() {

        name = "Chest";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/source/objects/chest.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
