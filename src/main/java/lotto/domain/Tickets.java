package lotto.domain;

import static lotto.global.Constants.LOTTO_PRICE;
import static lotto.global.Validator.validateTickets;

public class Tickets {

    private final int numberOfTickets;

    private Tickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public static Tickets of(int numberOfTickets) {
        return new Tickets(numberOfTickets);
    }

    public static Tickets buyTickets(int purchaseAmount) {
        validateTickets(purchaseAmount);
        int numberOfTickets = purchaseAmount / LOTTO_PRICE;
        return Tickets.of(numberOfTickets);
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public int getUserMoney() {
        return numberOfTickets * LOTTO_PRICE;
    }
}