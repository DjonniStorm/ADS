public class aads_lab1_task2 {
    public static void BubbleSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < arr.length - 1; j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {-1, -2};
        BubbleSort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }    
}
