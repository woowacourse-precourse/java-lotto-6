package lotto.domain;

import static lotto.constant.ErrorMessage.*;

import lotto.constant.ErrorMessage;

public class LottoPurchaseMoney {
    private static final int TICKET_PRICE = 1000;


    public int getTicketCount(int money){
        if (money % TICKET_PRICE != 0){
            throw new IllegalArgumentException(INVALID_DIVISION_AMOUNT.getMessage());
        }
        return money / TICKET_PRICE;
    }
}
