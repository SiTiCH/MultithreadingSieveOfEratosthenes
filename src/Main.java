import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Vector vector = new Vector();
        Scanner input = new Scanner(System.in);
        int vectorLength = input.nextInt();
        filling(vector,vectorLength);
        System.out.println("Hello World!");
        for(Object a : vector){
            System.out.println(a);
        }
        int sqrtLength = (int)Math.sqrt(vectorLength);
        Vector vector2 = new Vector();
        for (int i =0;i<sqrtLength;i++){
            vector2.add(vector.get(i));
        }
        System.out.println(vector2.size()+vector.size());
        System.out.println(sqrtLength);
    }

    private static void filling(Vector vector, int length){
        for(int i = 1;i<length+1;i++){
            vector.add(i);
        }
    }
}
