import java.lang.reflect.Array;

public class aads_lab1_task3 {
    static void qSort(int[] arr, int start, int end){
        if ( start >= end ) 
       {
           return;
       }
       int pivot = partition (arr, start, end);
       qSort (arr, start, pivot-1);
       qSort (arr, pivot+1, end);
    }
    static int partition (int[] array, int start, int end) 
   {
       int temp;
       int ptr = start;
       for ( int i = start; i < end; i++ ) 
       {
           if ( array[i] < array[end] )
           {
               temp = array[ptr];
               array[ptr] = array[i];
               array[i] = temp;
               ptr += 1;
           }
       }
       temp = array[ptr];
       array[ptr] = array[end];
       array[end] = temp; 
       return ptr;
   }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {-1, 1, 21, 6, -10, 8, 37, -63, 42, 10, 0};
        qSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
