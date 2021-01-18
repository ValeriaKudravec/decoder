import java.io.FileNotFoundException;

public class NumberDecryption {
    public String decoding(StringBuilder number, String numberNameFile, String numberDigitFile) throws FileNotFoundException {
        NumbersGuide numberNameGuide = new NumbersGuide();
        numberNameGuide.readData("numbers_name.txt");
        NumbersGuide numberRankGuide = new NumbersGuide();
        numberRankGuide.readData("numbers_digit.txt");
        int count = number.length();
        StringBuilder resultString = new StringBuilder("");
        for (int currentNumber = count-1, i = 0; currentNumber>=0; currentNumber--, i++){
            int rank = currentNumber%3;
            int smallRank = currentNumber/3;
            if(rank == 0){
                if (smallRank == 0){
                    if(number.charAt(i)!='0') {
                        String numberName = Integer.toString(rank) + number.charAt(i);
                        resultString.append(numberNameGuide.find(numberName));
                        resultString.append(" ");
                    }
                }
                else {
                    switch (number.charAt(i)){
                        case '0':{
                            String numberRank = Integer.toString(smallRank) + "3";
                            resultString.append(numberRankGuide.find(numberRank));
                            resultString.append(" ");
                            break;
                        }
                        case '1':{
                            String numberName = Integer.toString(rank) + number.charAt(i);
                            if(smallRank==1){
                                numberName+="1";
                            }
                            resultString.append(numberNameGuide.find(numberName));
                            resultString.append(" ");
                            String numberRank = Integer.toString(smallRank) + "1";
                            resultString.append(numberRankGuide.find(numberRank));
                            resultString.append(" ");
                            break;
                        }
                        case '2':{
                            String numberName = Integer.toString(rank) + number.charAt(i);
                            if(rank==1){
                                numberName+="1";
                            }
                            resultString.append(numberNameGuide.find(numberName));
                            resultString.append(" ");
                            String numberRank = Integer.toString(smallRank) + "2";
                            resultString.append(numberRankGuide.find(numberRank));
                            resultString.append(" ");
                            break;
                        }
                        case '3':{}
                        case '4':{
                            String numberName = Integer.toString(rank) + number.charAt(i);
                            resultString.append(numberNameGuide.find(numberName));
                            resultString.append(" ");
                            String numberRank = Integer.toString(smallRank) + "2";
                            resultString.append(numberRankGuide.find(numberRank));
                            resultString.append(" ");
                            break;
                        }
                        case '5':{}
                        case '6':{}
                        case '7':{}
                        case '8':{}
                        case '9':{
                            String numberName = Integer.toString(rank) + number.charAt(i);
                            resultString.append(numberNameGuide.find(numberName));
                            resultString.append(" ");
                            String numberRank = Integer.toString(smallRank) + "3";
                            resultString.append(numberRankGuide.find(numberRank));
                            resultString.append(" ");
                            break;}
                    }
                }
            }
            else {
                if (rank == 1 && number.charAt(i) == '1') {
                    String numberName = Integer.toString(rank) + number.charAt(i) + number.charAt(i+1);
                    number.replace(i+1, i+2, "0");
                    resultString.append(numberNameGuide.find(numberName));
                    resultString.append(" ");
                }
                else {
                    String numberName = Integer.toString(rank) + number.charAt(i);
                    resultString.append(numberNameGuide.find(numberName));
                    resultString.append(" ");
                }
            }

        }
        return resultString.toString();
    }
}
