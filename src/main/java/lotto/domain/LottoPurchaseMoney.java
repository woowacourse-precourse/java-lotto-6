package lotto.domain;

import static lotto.constant.ErrorMessage.*;

import lotto.constant.ErrorMessage;

public class LottoPurchaseMoney {
    private static final int TICKET_PRICE = 1000;

    private int money;

    public LottoPurchaseMoney(int money){
        validateTicket(money);
        this.money = money;
    }

    public void validateTicket(int money){
        if (money % TICKET_PRICE != 0){
            throw new IllegalArgumentException(INVALID_DIVISION_AMOUNT.getMessage());
        }
    }

    public int getTicketCount(){
        return money / TICKET_PRICE;
    }

    public int getMoney(){
        return money;
    }
}
