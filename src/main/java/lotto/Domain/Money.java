package lotto.Domain;


import static lotto.CommonValidation.CommonValidation.hasBlank;
import static lotto.CommonValidation.CommonValidation.isInteger;
import static lotto.Message.ExceptionMessage.MoneyErrorMessage.*;
import static lotto.Util.Util.ConvertStringToInteger;

import lotto.Exception.MoneyException;

public class Money {

    Integer money;

    public Money(String inputMoney) {
        hasBlank(inputMoney);
        isInteger(inputMoney);
        this.money = ConvertStringToInteger(inputMoney);
        isValidRange(money);
        isDivisible(money);
    }

    public static Money of(String inputMoney) {
        return new Money(inputMoney);
    }

    public Integer getMoney() {
        return money;
    }

    private void isValidRange(Integer money) {
        if (money < 1000 || money > 100000) {
            throw new MoneyException(RANGE_ERROR_MESSAGE.getMessage(money));
        }
    }

    private void isDivisible(Integer money) {
        if (money % 1000 != 0) {
            throw new MoneyException(DIVISIBILITY_ERROR_MESSAGE.getMessage(money));
        }
    }

}