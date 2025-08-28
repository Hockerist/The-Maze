package source.maps;

public class MapGenerator {
    public static void main(String[] args) {
        int totalSize = 32;   
        int wallThickness = 1;


        for (int i = 0; i < totalSize; i++) {
            for (int j = 0; j < totalSize; j++) {
                
                if (i < wallThickness || i >= totalSize - wallThickness ||
                    j < wallThickness || j >= totalSize - wallThickness) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
