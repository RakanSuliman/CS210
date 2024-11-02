import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
       NoWay noWay = new NoWay();
        // Create an array of size 10,000
        int[] A = new int[1000];

        // Fill the array with random numbers between 0 and 1000
        Random random = new Random();
        for (int i = 0; i < A.length; i++) {
            A[i] = random.nextInt(1001);  // Generates random number between 0 and 1000
        }

        // Measure start time
        long startTime = System.currentTimeMillis();


       noWay.WhatIsThis(A);

        // Measure end time
        long endTime = System.currentTimeMillis();

        // Calculate and print execution time
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " milliseconds");

        System.out.println(Arrays.toString(A));
    }
}
