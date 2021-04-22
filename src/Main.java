import java.io.*;
import java.util.Arrays;

/**
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * Desc: Comb Sort tutorial
 */

public class Main {
    private static void generateTC() {
        // generate the test cases
        try {
            TCGenerator.generate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // generate testcases
        generateTC();

        // reads test cases from file and sorts
        readFileAndSort();
    }

    private static void readFileAndSort() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("res/test_case.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("res/analysis.csv"));

            // write headers
            bw.write("TestCase,Array Size,Iterations,Swaps,Time (in nanoseconds),BubbleSort iterations,BubbleSort swaps\n");

            // first line containing number of test cases
            int testCases = Integer.parseInt(br.readLine());


            for (int i = 1; i <= testCases; i++) {

                // size of array
                int size = Integer.parseInt(br.readLine());

                // numbers in the array
                int[] array = Arrays.stream(br.readLine().trim().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                combSort(i,array, size, bw);
            }

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param array array containing integers
     * @param from position of number to be swapped
     * @param to position to which the number will be moved
     */
    private static void swap(int[] array, int from, int to){
        int fromValue = array[from];
        array[from] = array[to];
        array[to] = fromValue;
    }

    /**
     * Main function sorting the array using combsort algorithm
     * @param testCase the testcase id
     * @param array collection of integers
     * @param size size of these collection of numbers
     * @param bw an instance of BufferedWriter to the analysis/result file
     */
    private static void combSort(int testCase,int[] array, int size, BufferedWriter bw) throws IOException {
        assert (array.length == size);

        // -------STATISTICS----------
        int iterationsCount = 0;
        int swapsCount = 0;
        long timeInMilliSeconds;
        int[] arr2 = new int[array.length];
        System.arraycopy(array,0,arr2,0,array.length);

        // start time
        long start = System.nanoTime();

        int d = array.length;

        float k = 1.3f;

        boolean swapped = false;

        while (d > 1 || swapped) {
            if (d > 1) {
                d = (int)(d / k);
            }

            swapped = false;

            for (int i = 0; d + i < array.length; i++) {
                iterationsCount++;
                if (array[i] > array[i + d]) {
                    swap(array, i, i + d);
                    swapsCount++;
                    swapped = true;
                }
            }
        }
        timeInMilliSeconds = System.nanoTime() - start;

        // bubble sort col
        int bubbleswaps = 0;
        int bubbleit = 0;
        int n = arr2.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++){
                if (arr2[j] > arr2[j+1])
                {
                    swap(arr2,j,j+1);
                    bubbleswaps++;
                }
                bubbleit++;
            }

        // TestCase,Array Size,Iterations,Swaps,Time (in nanoseconds),BubbleIterations,BubbleSwaps
        String result = String.format("%d,%d,%d,%d,%d,%d,%d%n",testCase,size,iterationsCount,swapsCount,timeInMilliSeconds,bubbleit,bubbleswaps);
        bw.write(result);
    }
}
