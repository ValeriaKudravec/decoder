public class NumberValidator {
    public boolean validate(String number){

        if(number.charAt(0)=='0'){
            return false;
        }
        return number.matches("[-+]?\\d+");
    }
}
