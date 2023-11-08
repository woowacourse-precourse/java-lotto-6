package lotto;

import static lotto.ErrorCheck.validatePurchaseInput;

final class LottoInit {
    public int purchaseAmount;
    public int numberOfLotto;

    public LottoInit(int purchaseAmount, int numberOfLotto) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.numberOfLotto = numberOfLotto;
    }

    private void validatePurchaseAmount(int purchaseAmount){
        validatePurchaseInput(purchaseAmount);
    }
}
