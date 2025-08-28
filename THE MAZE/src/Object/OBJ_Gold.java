package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Gold extends SuperObject {
     
    // File Path for Gold Object.

    public OBJ_Gold() {

        name = "Gold";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/source/objects/gold.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}
