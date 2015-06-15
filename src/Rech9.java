import java.util.Random;

/**
 * Created by Funke/Stachova on 14.06.15.
 */
public class Rech9 {
    public static void main(String... args) {
        byte[][][] array = new byte[500][1024][1024];
        Random rand = new Random();

        for (int i = 0; i < 500; i++) {
            for (int k = 0; k < 1024; k++) {
                byte[] randomByteArray = new byte[1024];
                rand.nextBytes(randomByteArray);
                for (int l = 0; l < 1024; l++) {
                    array[i][k][l] = randomByteArray[l];
                }
            }
        }
        doIt(1, array);
        doIt(2, array);
        doIt(30, array);
        doIt(40, array);
        doIt(50, array);
        doIt(100, array);
        doIt(200, array);
        doIt(300, array);

    }

    public static void doIt(int amount, byte[][][] array) {
        final int rows = 500 / amount;

        Thread[] threads = new Thread[amount];
        for (int i = 0; i < amount; i++) {
            int part = i * rows;

            threads[i] = new Thread() {
                public void run() {
                    int mean = 0;
                    for (int m = part; m < part + rows; m++) {
                        for (int k = 0; k < 4; k++) {
                            for (int l = 0; l < 4; l++) {
                                //System.out.println(part+ "part   " + mean + " <mean  arrayfield> " + array[m][k][l]);
                                mean += array[m][k][l];
                            }
                        }
                    }
                    //System.out.println(mean);
                }
            };
        }
        long startTime = System.currentTimeMillis();
        for (Thread t : threads) {
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time (N=" + amount + "):" + (endTime - startTime));
    }
}
