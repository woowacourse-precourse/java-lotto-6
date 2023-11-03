package lotto.model;

public class PurchaseAmount {

    private final Integer amount;

    private PurchaseAmount(Integer amount) {
        validate(amount);
        this.amount = amount;
    }

    public static PurchaseAmount of(Integer value) {
        return new PurchaseAmount(value);
    }

    private void validate(Integer amount) {
        validateRange(amount);
        validateUnit(amount);
    }

    private void validateRange(Integer amount) {
        if (amount < 1000 || amount > 100000) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUnit(Integer amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public Integer exchangeLottoTicket() {
        return amount / 1000;
    }
}
