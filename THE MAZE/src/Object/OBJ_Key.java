package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Key extends SuperObject {

    // File Path for Key Object.
    
    public OBJ_Key() {

        name = "Key";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/source/objects/key.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
