package lotto.controller.dto.request;

public class PurchaseAmountDto {

    private int purchaseAmount;

    private PurchaseAmountDto(Integer purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmountDto from(String input) {
        return new PurchaseAmountDto(Integer.parseInt(input));
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
