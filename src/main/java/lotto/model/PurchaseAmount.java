package lotto.model;

public class PurchaseAmount {

    private final Integer amount;

    private PurchaseAmount(Integer amount) {
        this.amount = amount;
    }

    public static PurchaseAmount of(Integer value) {
        return new PurchaseAmount(value);
    }

    public Integer exchangeLottoTicket() {
        return amount / 1000;
    }
}
