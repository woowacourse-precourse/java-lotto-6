package lotto.domain;

import static lotto.constant.ErrorMessage.*;

import lotto.constant.ErrorMessage;

public class LottoPurchaseMoney {
    private static final int TICKET_PRICE = 1000;

    private final int lottoPurchaseMoney;

    public LottoPurchaseMoney(int money){
        validateTicket(money);
        lottoPurchaseMoney = money;
    }

    public void validateTicket(int money){
        if (money % TICKET_PRICE != 0){
            throw new IllegalArgumentException(INVALID_DIVISION_AMOUNT.getMessage());
        }
    }

    public int getTicketCount(){
        return lottoPurchaseMoney / TICKET_PRICE;
    }

    public int getMoney(){
        return lottoPurchaseMoney;
    }
}
