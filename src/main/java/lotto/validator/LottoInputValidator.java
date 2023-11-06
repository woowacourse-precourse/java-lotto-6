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

    public static void validateInputBonusNumberNumeric(String number) {
        if(!isNumber(number)){
            throw new IllegalArgumentException("[ERROR]: 보너스 번호는 1과 45사이의 숫자여야 합니다.");
        }
    }
}
