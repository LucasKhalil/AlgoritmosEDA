import java.util.Arrays;
import Algoritmos.Array;

public class Main {

    public static void main(String[] args) {
        Array array = new Array(new int[] { 57834, 41245, 42323, 63213, 39872, 21231, 20982, 11233, 80000 });
        array.quickSort();
        System.out.println(Arrays.toString(array.getContent()));
    }
}