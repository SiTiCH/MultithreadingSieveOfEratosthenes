import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Vector vector = new Vector();
        System.out.print("Введите длину вектора: ");
        Scanner input = new Scanner(System.in);
        int vectorLength = input.nextInt();
        filling(vector, vectorLength);
        Iterator var4 = vector.iterator();

        while(var4.hasNext()) {
            Object a = var4.next();
            System.out.println(a);
        }

        int sqrtLength = (int)Math.sqrt((double)vectorLength);
        System.out.println(sqrtLength);
        sqrtLength = sieveOfEratosthenes(vector);
    }

    private static void filling(Vector vector, int length) {
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
                if ((Integer)vector.get(j) % (Integer)vector.get(i) == 0) {
                    vector.remove(j);
                    --length;
                    if (j < sqrtLength) {
                        --sqrtLength;
                    }
                }
            }
        }

        System.out.println("??");
        System.out.println(sqrtLength + "?????");
        Iterator var5 = vector.iterator();

        while(var5.hasNext()) {
            j = (Integer)var5.next();
            System.out.println(j);
        }

        return sqrtLength;
    }
}
