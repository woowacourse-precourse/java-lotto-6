package lotto.validator;


import lotto.constants.Constants;
import lotto.utils.Utils;

public class InputValidator {
    private int totalMoney;

    public int checkAll(String money) throws IllegalArgumentException{
        checkInteger(money);
        totalMoney = Utils.makeStringToInteger(money);
        checkRemainder(totalMoney);
        return totalMoney;

    }

    public void checkRemainder (int money) throws IllegalArgumentException{
        if(money % Constants.LOTTO_PRICE != Constants.ZERO){
             throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요");
        }
    }
    public void checkInteger (String money) throws IllegalArgumentException{
        if(!Constants.INTEGER.matcher(money).matches()){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요");
        }
    }

}
