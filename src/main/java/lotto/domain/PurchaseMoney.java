package lotto.domain;

import static lotto.enums.ExceptionMessages.*;
import static lotto.utils.LottoNumberUtil.removeSpace;
import static lotto.utils.LottoNumberUtil.splitComma;

import java.util.Arrays;
import lotto.enums.Constants;

public class PurchaseMoney {

    private int value;

    public PurchaseMoney(String money){
        validate(money);
        money = removeSpace(money);
        this.value = Integer.valueOf(money);
    }

    public int getValue(){
        return value;
    }

    private void validate(String money){

        if(isEmpty(money)){
            PURCHASE_MONEY_IS_EMPTY_VALUE.throwException();
        }

        money = removeSpace(money);

        if(!isDigit(money)){
            PURCHASE_MONEY_IS_NOT_NUMBER.throwException();
        }

        if(isLessThanOneThousand(money)){
            PURCHASE_MONEY_IS_NOT_OVER_ONE_THOUSAND.throwException();
        }

        if(!isDividedByOneThousand(money)){
            PURCHASE_MONEY_IS_NOT_DIVIDENED_BY_ONE_THOUSAND.throwException();
        }
    }

    private boolean isEmpty(final String money){
        return money == null || money.isBlank();
    }

    private boolean isDigit(String money){

        money = money.replace("-","");
        String[] splitMoney = money.split("");
        return Arrays.stream(splitMoney).allMatch(number -> Character.isDigit(number.charAt(0)));
    }

    private boolean isDividedByOneThousand(final String money){

        return Integer.valueOf(money) % Constants.ONE_LOTTO_TICKET_PRICE.getValue() == 0;
    }

    private boolean isLessThanOneThousand(String money){

        return Integer.valueOf(money) < Constants.ONE_LOTTO_TICKET_PRICE.getValue();
    }
}
