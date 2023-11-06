package lotto.domain;

import static lotto.enums.ExceptionMessages.*;

import lotto.enums.Constants;
import lotto.utils.RemoveSpace;

public class PurchaseMoney {

    private int value;

    public PurchaseMoney(String money){
        validate(money);
        money = RemoveSpace.getValue(money);
        this.value = Integer.valueOf(money);
    }

    public int getValue(){
        return value;
    }

    private void validate(String money){

        if(isEmpty(money)){
            PURCHASE_MONEY_IS_EMPTY_VALUE.throwException();
        }

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

        for (int i = 0; i < money.length(); i++) {
            if(!Character.isDigit(money.charAt(i))) return false;
        }

        return true;
    }

    private boolean isDividedByOneThousand(final String money){

        return Integer.valueOf(money) % Constants.ONE_LOTTO_TICKET_PRICE.getValue() == 0;
    }

    private boolean isLessThanOneThousand(String money){

        return Integer.valueOf(money) < Constants.ONE_LOTTO_TICKET_PRICE.getValue();
    }
}
