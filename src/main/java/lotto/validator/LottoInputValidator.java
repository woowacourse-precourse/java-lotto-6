package lotto.validator;

public class LottoInputValidator {
    public static boolean isNumber(String number){
        boolean isNumeric = false;
        for(int index=0;index<number.length();index++){
            isNumeric = Character.isDigit(number.charAt(index));
            if(!isNumeric){
                return false;
            }
        }
        return isNumeric;
    }
}
