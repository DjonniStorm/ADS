public class Task2 {
    private static void fib(int n, long[] array) {
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        System.out.println(array[n - 1]);
        //return array[n - 1];
    }   
    public static void main(String[] args) {
        int n = 1000;
        long[] array = new long[n];
        array[0] = 1; array[1] = 1;
        fib(n, array);
        //System.out.println(fib(1));
    }
}
