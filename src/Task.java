import java.util.Vector;

public class Task extends Thread {
    private Vector<Integer> vector;
    private int sqrtLength;
    private int sectorSize;
    private byte numberOfThread;

    public Task(Vector<Integer> vec, int sqrt, int sectorSize, byte num) {
        this.vector = vec;
        this.sqrtLength = sqrt;
        this.sectorSize = sectorSize;
        this.numberOfThread = num;
        sieveOfEratosthenes();
    }

    public void run() {
        sieveOfEratosthenes();
    }

    private void sieveOfEratosthenes() {
        int length = vector.size();
        int j;
        for(int i = numberOfThread*sectorSize; (i < numberOfThread*sectorSize+sectorSize)&&i<sqrtLength; ++i) {
            for(j = sqrtLength; j < length; ++j) {
                if (vector.get(j) % vector.get(i) == 0) {
                    vector.remove(j);
                    --length;
                }
            }
        }
    }
}