package lotto.model;

public class BonusNumber {
    private static final String SPECIAL_REGEX = "[!@#$%^&*()_+=\\[\\]{};':,\"\\\\|.<>/?-]";
    private static final String NUMERIC_REGEX = "[1-9]+";

    private final String BONUS_NUMBER;
    public BonusNumber(String bonusNumber){
        isNotDigits(bonusNumber);
        isWrongNumberRange(bonusNumber);
        this.BONUS_NUMBER = bonusNumber;

    }

    public String getBonusNumber(){
        return this.BONUS_NUMBER;
    }
    private void isNotDigits(String bonusNumber) throws IllegalArgumentException{
        if(!bonusNumber.matches(NUMERIC_REGEX)){
            throw new IllegalArgumentException("[ERROR] 숫자의 입력은 1이상 45이하의 정수입니다.");
        }
    }

    private void isWrongNumberRange(String bonusNumber) throws IllegalArgumentException{
        if(Integer.parseInt(bonusNumber) < 1 || Integer.parseInt(bonusNumber) > 45){
            throw new IllegalArgumentException("[ERROR] 숫자의 입력은 1이상 45이하의 정수입니다.");
        }
    }
}
