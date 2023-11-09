package lotto.dto.request;

public class PurchasePriceRequest {
    private final long price;

    public PurchasePriceRequest(final long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }
}
