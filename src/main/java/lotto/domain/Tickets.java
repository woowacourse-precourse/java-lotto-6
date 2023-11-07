package lotto.domain;

import lotto.view.InputView;

public class Tickets {

    private static final int LOTTO_PRICE = 1000;

    private final int numberOfTickets;

    private Tickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public static Tickets of(int numberOfTickets) {
        return new Tickets(numberOfTickets);
    }

    private static void validatePurchaseAmount(int purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다.");
        }
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위로 입력 가능합니다.");
        }

    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public static Tickets buyTickets(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int numberOfTickets = purchaseAmount / LOTTO_PRICE;
        return Tickets.of(numberOfTickets);
    }

    public int getUserMoney() {
        return numberOfTickets * LOTTO_PRICE;
    }
}
