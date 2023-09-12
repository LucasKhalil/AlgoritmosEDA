package Algoritmos;

public class Math {

    public static void main(String[] args) {
        System.out.println(root(16, 2));

    }

    public static int power(int num, int pow) {
        int potNum = 1;
        for (int i = 0; i < pow; i++) {
            potNum *= num;
        }
        return potNum;
    }

    public static int root(int num, int x) {
        if (num == 1) {
            return 1;
        }
        int head = 0;
        int tail = num;
        while (true) {
            int midValue = (tail - head) / 2 + head;
            int power = power(num, x);
            System.out.println(midValue + tail + head);
            if (power > num) {
                tail = midValue;
                continue;
            }
            if (power < num) {
                head = midValue;
                continue;
            }
            if (power == num)
                return midValue;
        }

    }

}
