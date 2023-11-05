package lotto.util;

public class Validator {

    public void validateInputMoneyIsNumber(String inputMoney) {
        try{
            Long.parseLong(inputMoney);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력이 되어져야 합니다!");
        }
    }


}
