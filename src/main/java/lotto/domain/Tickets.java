package lotto.domain;

public class Tickets {

    private static final int LOTTO_PRICE = 1000;

    private final int numberOfTickets;

    private Tickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public static Tickets of(String purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int numberOfTickets = Integer.parseInt(purchaseAmount) / LOTTO_PRICE;
        return new Tickets(numberOfTickets);
    }

    private static void validatePurchaseAmount(String purchaseAmount) {
        if (purchaseAmount == null || purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException("구입 금액을 입력해주세요.");
        }
        if (!purchaseAmount.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("구입 금액은 숫자만 입력 가능합니다.");
        }
        if (Integer.parseInt(purchaseAmount) < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입 금액은 최소 1000원 이상이어야 합니다.");
        }
        if (Integer.parseInt(purchaseAmount) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위로 입력 가능합니다.");
        }
    }
}
