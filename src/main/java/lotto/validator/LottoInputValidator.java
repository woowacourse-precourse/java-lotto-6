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

    public static boolean isOverOneUnderFortyFive(int number){
        if(isNotInCondition(number)) {
            return false;
        } return true;
    }

    private static boolean isNotInCondition(int number) {
        return !(number >= 1 && number <= 45);
    }

    public static void validateBonusNumberNumeric(String number) {
        if(!isNumber(number)){
            throw new IllegalArgumentException("[ERROR]: 보너스 번호는 1과 45사이의 숫자여야 합니다.");
        }
    }

    public static void validateBonusNumberRange(int number) {
        if(!isOverOneUnderFortyFive(number)) {
            throw new IllegalArgumentException("[ERROR]: 보너스 번호는 1과 45사이의 숫자여야 합니다.");
        }
    }
}
