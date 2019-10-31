
import java.util.Iterator;
import java.util.Vector;

public class TaskPartOne extends Thread {
    private Vector<Integer> vector;
    private int sqrtLength;
    private int length;

    public TaskPartOne(Vector vec,int sqrt,int sectorSize) {
        this.vector = vec;
    }

    public void run() {
    }

    private void sieveOfEratosthenes(Vector<Integer> vector,int sectorSize) {
        int length = vector.size();
        int j;
        for(int i = 0; i < sectorSize; ++i) {
            for(j = i + 1; j < length - 1; ++j) {
                if (vector.get(j) % vector.get(i) == 0) {
                    vector.remove(j);
                    --length;
                }
            }
        }
    }
}