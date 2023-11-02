package Model;

import Config.ErrorMessage;
import Config.GameConfig;

public class Money {

    private final int money;

    Money(String inputMoney){
        int money = validateNumeric(inputMoney);
        validateMultiple(money);
        validateZero(money);
        this.money = money;
    }

    public int getLottoNumber(){
        return money/GameConfig.MONEY_UNIT;
    }

    private int validateNumeric(String money){
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC.getErrorMessage());
        }
    }

    private void validateMultiple(int money){
        if (money % GameConfig.MONEY_UNIT != 0){
            throw new IllegalArgumentException(ErrorMessage.NON_MULTIPLE.getErrorMessage());
        }
    }

    private void validateZero(int money){
        if (money == 0){
            throw new IllegalArgumentException(ErrorMessage.NON_ZERO.getErrorMessage());
        }
    }
}
