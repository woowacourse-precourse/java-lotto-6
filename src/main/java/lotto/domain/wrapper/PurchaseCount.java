package lotto.domain.wrapper;

public class PurchaseCount {
    private int count;

    private PurchaseCount(final int count) {
        this.count = count;
    }

    public static PurchaseCount create(int count) {
        return new PurchaseCount(count);
    }
}
