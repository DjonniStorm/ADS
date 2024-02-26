public class aads_lab1_task3 {
    public static void qSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int selectedElem = sort(arr, left, right);
        qSort(arr, left, selectedElem - 1);
        qSort(arr, selectedElem, right);
    }
    public static int sort(int[] arr, int left, int right) {
        int refElem = arr[(right + left) / 2];
        while (left <= right) {
            while (arr[left] < refElem) { left++; }
            while (arr[right] > refElem) { right--; }
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++; right--;
            }

        }
        return left;
    }
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, -1, -2, 0};
        qSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
