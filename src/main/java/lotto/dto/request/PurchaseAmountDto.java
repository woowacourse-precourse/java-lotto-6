package lotto.dto.request;

public class PurchaseAmountDto {
    private final String purchaseAmount;

    private PurchaseAmountDto(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmountDto from(String purchaseAmount) {
        return new PurchaseAmountDto(purchaseAmount);
    }

    public String getAmount() {
        return purchaseAmount;
    }
}
