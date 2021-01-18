import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class NumbersGuide {

    private HashMap<String, String> giudeData;

    public NumbersGuide(){
        giudeData = new HashMap<>();
    }
    public void readData(String fileName) throws FileNotFoundException {
        try(Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()){
                try {
                    String numbersDecryption = scanner.nextLine();
                    String[] numbersLineArr = numbersDecryption.split("\\s");
                    giudeData.put(numbersLineArr[0], numbersLineArr[1]);
                }
                catch (RuntimeException e){
                    System.out.println("Line in file is uncorrect");
                }
            }
        }
    }

    public String find(String number){
        return giudeData.get(number);
    }
    public HashMap<String, String> getGiudeData() {
        return giudeData;
    }

    public void setGiudeData(HashMap<String, String> giudeData) {
        this.giudeData = giudeData;
    }
}
