import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector();
        System.out.print("Введите длину вектора: ");
        Scanner input = new Scanner(System.in);
        int vectorLength = input.nextInt();
        filling(vector, vectorLength);
        int sqrtLength = (int)Math.sqrt((double)vectorLength);
        System.out.println(sqrtLength);
        sqrtLength = sieveOfEratosthenes(vector);
        byte quantityOfThread;
        System.out.println("Введите количество потоков: ");
        quantityOfThread= input.nextByte();
        Task[] task = new Task[quantityOfThread];
        int sectorSize = sqrtLength/quantityOfThread;
        for(byte i =0;i<quantityOfThread;i++){
            task[i]=new Task(vector,sqrtLength,sectorSize,i);
        }
        for(Task t : task){
            t.run();
        }
        for(Integer a : vector){
            System.out.println(a);
        }
        System.out.print(vector.size());

    }

    private static void filling(Vector<Integer> vector, int length) {
        for(int i = 1; i < length + 1; ++i) {
            vector.add(i);
        }
    }

    private static int sieveOfEratosthenes(Vector<Integer> vector) {
        int length = vector.size();
        int sqrtLength = (int)Math.sqrt((double)length);
        int j;
        for(int i = 0; i < sqrtLength; ++i) {
            for(j = i + 1; j < length - 1; ++j) {
                if (vector.get(j) % vector.get(i) == 0) {
                    vector.remove(j);
                    --length;
                    if (j < sqrtLength) {
                        --sqrtLength;
                    }
                }
            }
        }
        return sqrtLength;
    }
}
