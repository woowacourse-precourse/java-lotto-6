package lotto.Domain;


import static lotto.CommonValidation.CommonValidation.hasBlank;
import static lotto.CommonValidation.CommonValidation.isInteger;
import static lotto.Dictionary.LottoDictionary.*;
import static lotto.Dictionary.MoneyDictionary.*;
import static lotto.Message.ExceptionMessage.MoneyErrorMessage.*;
import static lotto.Util.Util.ConvertStringToInteger;

import lotto.Dictionary.LottoDictionary;
import lotto.Dictionary.MoneyDictionary;
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
        if (money < MONEY_MIN_NUMBER.getValue() || money > MONEY_MAX_NUMBER.getValue()) {
            throw new MoneyException(RANGE_ERROR_MESSAGE.getMessage(money));
        }
    }

    private void isDivisible(Integer money) {
        if (money % LOTTO_PRICE.getValue() != 0) {
            throw new MoneyException(DIVISIBILITY_ERROR_MESSAGE.getMessage(money));
        }
    }

}