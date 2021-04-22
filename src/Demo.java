import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * Desc: Comb Sort
 */
public class Demo {
    public static void main(String[] args) {
        try {
            int[][] array = readTestCases();
            for (int[] ints : array) {
                combSort(ints);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void swap(int[] arr, int from, int to){
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
    private static void combSort(int[] arr) {
        float k = 1.3f;
        int d = arr.length;
        boolean swapped = false;

        while (d > 1 || swapped) {
            if (d > 1) {
                d = (int) (d / k);
            }
            swapped = false;
            for (int i = 0; i < arr.length - d; i++) {
                if(arr[i]>arr[i+d]){
                    swap(arr,i,i+d);
                    swapped = true;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    private static int[][] readTestCases() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("res/test_case.txt"));
        int testCaseCount = Integer.parseInt(br.readLine());

        int[][] testCases = new int[testCaseCount][];
        for (int i = 0; i < testCaseCount; i++) {
            int size = Integer.parseInt(br.readLine().trim());
            int[] arr = Arrays.stream(br.readLine().trim().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            testCases[i] = arr;
        }
        return testCases;
    }
}
