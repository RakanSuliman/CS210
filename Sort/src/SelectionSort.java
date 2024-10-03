public class SelectionSort {
    public void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    public void printArray(int[] arr) {
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
