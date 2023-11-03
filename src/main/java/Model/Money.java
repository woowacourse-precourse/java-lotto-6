package Model;

import Config.ErrorMessage;
import Config.GameConfig;

public class Money {

    private final int money;

    public Money(String inputMoney){
        int money = validateNumeric(inputMoney);
        validateMultiple(money);
        validateZero(money);
        this.money = money;
    }

    public int getLottoNumber(){
        return money/GameConfig.MONEY_UNIT;
    }

    public String getYield(int winning){
        String roundFormat = "%.".concat(Integer.toString(GameConfig.ROUND_DIGIT).concat("f"));
        return String.format(roundFormat, (double)winning * 100 / money).concat("%");
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
            throw new IllegalArgumentException(String.format(ErrorMessage.NON_MULTIPLE.getErrorMessage(), GameConfig.MONEY_UNIT));
        }
    }

    private void validateZero(int money){
        if (money == 0){
            throw new IllegalArgumentException(ErrorMessage.NON_ZERO.getErrorMessage());
        }
    }
}
