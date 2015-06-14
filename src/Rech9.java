import java.util.Random;

/**
 * Created by kevin on 14.06.15.
 */
public class Rech9 {
    public static void main(String... args) {
        byte[][][] array = new byte[500][1024][1024];
        Random rand = new Random();

        for (int i = 0; i < 500; i++) {
            for (int k = 0; k < 1024; k++) {
                for (int l = 0; l < 1024; l++) {
                    byte[] randomByteArray = new byte[1];
                    rand.nextBytes(randomByteArray);
                    array[i][k][l] = randomByteArray[0];
                    System.out.println(array[i][k][l]);
                }
            }
        }
    }
}
