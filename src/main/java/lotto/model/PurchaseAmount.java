package lotto.model;

public record PurchaseAmount(int purchaseAmount) {

    private final static int LOTTO_UNIT_PRICE = 1000;

    public int getNumberOfTickets() {
        return purchaseAmount / LOTTO_UNIT_PRICE;
    }
}
