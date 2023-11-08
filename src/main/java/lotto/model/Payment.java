package lotto.model;

import lotto.constant.ModelConstant;
import lotto.validator.PaymentValidator;

public class Payment {

    private final int ticket;

    public Payment(String input) {
        PaymentValidator.validate(input);
        int price = Integer.parseInt(input);
        this.ticket = calculateTicketsCount(price);
    }

    public int calculateTicketsCount(int price) {
        return price / ModelConstant.TICKET_PRICE;
    }

   public int getTicket() {
        return ticket;
   }

}
