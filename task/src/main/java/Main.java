
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static final String  numberNameFile = "numbers_name.txt";
    private static final String  numberDigitFile = "numbers_digit.txt";
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)){
            NumberValidator numberValidator = new NumberValidator();
            System.out.print("Input a number: ");
            StringBuilder num = new StringBuilder(in.nextLine());
            if (numberValidator.validate(num.toString())) {
                NumberDecryption numberDecryption = new NumberDecryption();
                System.out.println(numberDecryption.decoding(num, numberNameFile, numberDigitFile));
            }
            else {
                System.out.println("invalid number");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
