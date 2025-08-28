package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject {

        // File Path for Door Object.

        public OBJ_Door() {

        name = "Door";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/source/objects/iron_door.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }

        collision = true;
        
    }
}
