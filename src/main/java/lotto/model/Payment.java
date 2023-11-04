package lotto.model;

import lotto.validator.PaymentValidator;

import java.util.regex.Pattern;

public class Payment {
    private final int ticket;
    public Payment(String input) {
        PaymentValidator.validate(input);
        int price = Integer.parseInt(input);
        this.ticket = calculateTicketsCount(price);
    }

    public int calculateTicketsCount(int price) {
        return price/1000;
    }

   public int getTicket() {
        return ticket;
   }

}
