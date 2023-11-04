package lotto.domain;

public class Tickets {

    private static final int LOTTO_PRICE = 1000;

    private final int numberTickets;

    private Tickets(int numberOfTickets) {
        this.numberTickets = numberOfTickets;
    }

    public int getNumberTickets() {
        return numberTickets;
    }

    public static Tickets of(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int numberOfTickets = purchaseAmount / LOTTO_PRICE;
        return new Tickets(numberOfTickets);
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다.");
        }
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위로 입력 가능합니다.");
        }
    }
}
