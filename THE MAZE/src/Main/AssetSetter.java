package Main;

import Object.OBJ_Chest;
import Object.OBJ_Diamond;
import Object.OBJ_Door;
import Object.OBJ_Gold;
import Object.OBJ_Key;

public class AssetSetter {

    // This is where we set the object location...

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        
        // OBJECT TREASURE ROOM
        gp.obj[0] = new OBJ_Chest();
        gp.obj[0].worldX = 14 * gp.tileSize;
        gp.obj[0].worldY = 14 * gp.tileSize;

        gp.obj[1] = new OBJ_Chest();
        gp.obj[1].worldX = 15 * gp.tileSize;
        gp.obj[1].worldY = 14 * gp.tileSize;

        gp.obj[2] = new OBJ_Chest();
        gp.obj[2].worldX = 16 * gp.tileSize;
        gp.obj[2].worldY = 14 * gp.tileSize;

        gp.obj[3] = new OBJ_Door();
        gp.obj[3].worldX = 15 * gp.tileSize;
        gp.obj[3].worldY = 17 * gp.tileSize;

        gp.obj[4] = new OBJ_Key();
        gp.obj[4].worldX = 12 * gp.tileSize;
        gp.obj[4].worldY = 30 * gp.tileSize;
        
        // SCATTERED OBJECTS GOLD & DIAMOND

        gp.obj[5] = new OBJ_Gold();
        gp.obj[5].worldX = 2 * gp.tileSize;
        gp.obj[5].worldY = 1 * gp.tileSize;

        gp.obj[6] = new OBJ_Gold();
        gp.obj[6].worldX = 8 * gp.tileSize;
        gp.obj[6].worldY = 1 * gp.tileSize;

        gp.obj[7] = new OBJ_Gold();
        gp.obj[7].worldX = 30 * gp.tileSize;
        gp.obj[7].worldY = 13 * gp.tileSize;

        gp.obj[8] = new OBJ_Gold();
        gp.obj[8].worldX = 8 * gp.tileSize;
        gp.obj[8].worldY = 7 * gp.tileSize;

        gp.obj[9] = new OBJ_Gold();
        gp.obj[9].worldX = 5 * gp.tileSize;
        gp.obj[9].worldY = 1 * gp.tileSize;

        gp.obj[10] = new OBJ_Gold();
        gp.obj[10].worldX = 26 * gp.tileSize;
        gp.obj[10].worldY = 11 * gp.tileSize;

        gp.obj[11] = new OBJ_Gold();
        gp.obj[11].worldX = 22 * gp.tileSize;
        gp.obj[11].worldY = 13 * gp.tileSize;

        gp.obj[12] = new OBJ_Gold();
        gp.obj[12].worldX = 3 * gp.tileSize;
        gp.obj[12].worldY = 28 * gp.tileSize;

        gp.obj[13] = new OBJ_Gold();
        gp.obj[13].worldX = 8 * gp.tileSize;
        gp.obj[13].worldY = 17 * gp.tileSize;

        gp.obj[14] = new OBJ_Gold();
        gp.obj[14].worldX = 1 * gp.tileSize;
        gp.obj[14].worldY = 17 * gp.tileSize;

        gp.obj[15] = new OBJ_Diamond();
        gp.obj[15].worldX = 30 * gp.tileSize;
        gp.obj[15].worldY = 4 * gp.tileSize;

        gp.obj[16] = new OBJ_Diamond();
        gp.obj[16].worldX = 29 * gp.tileSize;
        gp.obj[16].worldY = 30 * gp.tileSize;

        gp.obj[17] = new OBJ_Diamond();
        gp.obj[17].worldX = 23 * gp.tileSize;
        gp.obj[17].worldY = 27 * gp.tileSize;

        gp.obj[17] = new OBJ_Diamond();
        gp.obj[17].worldX = 21 * gp.tileSize;
        gp.obj[17].worldY = 30 * gp.tileSize;

        gp.obj[18] = new OBJ_Diamond();
        gp.obj[18].worldX = 17 * gp.tileSize;
        gp.obj[18].worldY = 27 * gp.tileSize;
        
        gp.obj[19] = new OBJ_Diamond();
        gp.obj[19].worldX = 12 * gp.tileSize;
        gp.obj[19].worldY = 30 * gp.tileSize;
        
        gp.obj[19] = new OBJ_Diamond();
        gp.obj[19].worldX = 8 * gp.tileSize;
        gp.obj[19].worldY = 15 * gp.tileSize;

        gp.obj[20] = new OBJ_Gold();
        gp.obj[20].worldX = 10 * gp.tileSize;
        gp.obj[20].worldY = 11 * gp.tileSize;

        gp.obj[21] = new OBJ_Gold();
        gp.obj[21].worldX = 12 * gp.tileSize;
        gp.obj[21].worldY = 11 * gp.tileSize;

        gp.obj[22] = new OBJ_Diamond();
        gp.obj[22].worldX = 1 * gp.tileSize;
        gp.obj[22].worldY = 10 * gp.tileSize;

        gp.obj[23] = new OBJ_Gold();
        gp.obj[23].worldX = 1 * gp.tileSize;
        gp.obj[23].worldY = 8 * gp.tileSize;

        gp.obj[24] = new OBJ_Gold();
        gp.obj[24].worldX = 3 * gp.tileSize;
        gp.obj[24].worldY = 7 * gp.tileSize;

        gp.obj[25] = new OBJ_Gold();
        gp.obj[25].worldX = 12 * gp.tileSize;
        gp.obj[25].worldY = 5 * gp.tileSize;

        gp.obj[26] = new OBJ_Diamond();
        gp.obj[26].worldX = 16 * gp.tileSize;
        gp.obj[26].worldY = 10 * gp.tileSize;

        // TREASURES IN THE TREASURE ROOM

        gp.obj[27] = new OBJ_Diamond();
        gp.obj[27].worldX = 15 * gp.tileSize;
        gp.obj[27].worldY = 15 * gp.tileSize;

        gp.obj[28] = new OBJ_Gold();
        gp.obj[28].worldX = 14 * gp.tileSize;
        gp.obj[28].worldY = 15 * gp.tileSize;

        gp.obj[29] = new OBJ_Gold();
        gp.obj[29].worldX = 16 * gp.tileSize;
        gp.obj[29].worldY = 15 * gp.tileSize;

        gp.obj[30] = new OBJ_Gold();
        gp.obj[30].worldX = 14 * gp.tileSize;
        gp.obj[30].worldY = 16 * gp.tileSize;

        gp.obj[31] = new OBJ_Gold();
        gp.obj[31].worldX = 16 * gp.tileSize;
        gp.obj[31].worldY = 16 * gp.tileSize;
    }   
}
