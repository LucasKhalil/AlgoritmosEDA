import java.util.Arrays;
import Algoritmos.Array;

public class Main {

    public static void main(String[] args) {
        Array array = new Array(new int[] { 5, 4, 4, 6, 3, 2, 1, 8 });
        array.countingSort();
        System.out.println(Arrays.toString(array.getContent()));
    }
}