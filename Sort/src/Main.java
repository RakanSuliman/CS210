import sun.nio.ch.SelChImpl;

public class Main {
    public static void main(String[] args) {
 //    InsertionSort ss = new InsertionSort();
     BubbleSort ss = new BubbleSort();
//      SelectionSort ss = new SelectionSort();
        int[] x = new int[100000000];
        for (int i = 0; i < x.length; i++) {
            x[i] = (int) (1 + (Math.random() * 10000));  // Generates random number between 1 and 10000
        }

        // Measure start time
        long startTime = System.currentTimeMillis();

        // Perform bubble sort
        ss.bubbleSort(x);

        // Measure end time
        long endTime = System.currentTimeMillis();

        // Calculate and print execution time
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " milliseconds");

        // Print sorted array
//        ss.printArray(x);
    }
}
