

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberDecryptionTest {
    private static final String  numberNameFile = "numbers_name.txt";
    private static final String  numberDigitFile = "numbers_digit.txt";
    private static final String  fileTest = "fileTest.txt";

    @Test
    public void dataDriverTest(){
        try (Scanner scanner = new Scanner(new File(fileTest))){
            NumberDecryption numberDecryption = new NumberDecryption();
            while (scanner.hasNextLine()){
                String[] numbersLineArr = scanner.nextLine().split("-");
                Assert.assertEquals(numbersLineArr[1].trim(), numberDecryption.decoding(new StringBuilder(numbersLineArr[0]),
                        numberNameFile, numberDigitFile).trim());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}