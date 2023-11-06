package lotto.model;

public class Purchase { //도메인 로직과 관련된 구입 금액 검증 및 저장, 구입 금액에 따른 구매 횟수 계산

    private final int purchaseAmount;
    private final int purchaseNumber;

    public Purchase(String purchaseAmount) {
        int purchaseMoney = Integer.parseInt(purchaseAmount);
        validatePurchaseAmount(purchaseMoney);
        this.purchaseAmount = purchaseMoney;
        this.purchaseNumber = purchaseMoney / 1000;
    }

    private void validatePurchaseAmount(int purchaseMoney) {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getPurchaseNumber() {
        return purchaseNumber;
    }


}
