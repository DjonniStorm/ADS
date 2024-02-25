public class aads_lab1_task3 {
    public static void qSort(int[] arr){
        if (arr.length <= 1) return;
        int temp = arr[(arr.length - 1) / 2];
        int[] tempArr1 = new int[arr.length / 2 - 1];
        int[] tempArr2 = new int[arr.length / 2 - 1];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < temp){
                for (int j = 0; j < arr.length / 2 - 1; j++){
                    if (tempArr1[j] == 0) tempArr1[j] = arr[i];
                }
            } else {
                for (int j = 0; j < arr.length / 2 - 1; j++){
                    if (tempArr2[j] == 0) tempArr2[j] = arr[i];
                }
            }
        }
        printArr(tempArr1);
        printArr(tempArr2);
    }
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void sort(int[] arr) {
        if (arr.length <= 1) return;

    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 0, 6};
        qSort(arr);
        // for (int i = 0; i < arr.length; i++){
        //     System.out.print(arr[i] + " ");
        // }
    }
}
