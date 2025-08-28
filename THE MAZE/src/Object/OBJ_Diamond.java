package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Diamond extends SuperObject {
    
    // File Path for Diamond Object.

    public OBJ_Diamond() {

        name = "Diamond";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/source/objects/diamond.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}

