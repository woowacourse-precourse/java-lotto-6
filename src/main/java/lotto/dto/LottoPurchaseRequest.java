package lotto.dto;

public class LottoPurchaseRequest {

    private int purchaseAmount;

    public LottoPurchaseRequest(String purchaseAmount) {
        try {
            this.purchaseAmount = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자여야 합니다.");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
