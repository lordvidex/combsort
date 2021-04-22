import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by IntelliJ IDEA
 * Date: 16.04.2021
 * Time: 1:11 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class TCGenerator {
    static final int TEST_CASE_COUNT = 100;
    /**
     * Generates 100 random testcases containing 100 - 10000 numbers
     * to the <b>res</b> folder
     */
    public static void generate() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("res/test_case.txt"));
        Random random = new Random();

        // number of test cases
        bw.write(TEST_CASE_COUNT + "\n");
        for (int i = 1; i <= TEST_CASE_COUNT; i++) {

            // first indicate the size of this array
            bw.write((i*100)+"\n");
            for (int j = 0; j < i * 100; j++){
                bw.write(random.nextInt(500) + " ");
            }
            bw.newLine();
        }
        bw.close();
    }
}
