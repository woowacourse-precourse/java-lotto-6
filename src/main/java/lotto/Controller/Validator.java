package lotto.Controller;

public class Validator {
    public static boolean validateInputPurchaseAmount(String input){
        return Integer.parseInt(input) % 1000 == 0 && Integer.parseInt(input) > 0;
    }

    public static boolean validateInputIsNumeric(String input){
        try{
            int validate = Integer.parseInt(input);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    public static boolean validateInputIsNull(String input){
        return input==null;
    }
}
