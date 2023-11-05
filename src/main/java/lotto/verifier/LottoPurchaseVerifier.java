package lotto.verifier;

import lotto.exception.ExceptionMsg;

public class LottoPurchaseVerifier {
    private String purchaseAmount;

    public LottoPurchaseVerifier(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void verifyNull(int purchaseAmount) {
        if (this.purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMsg.NULL_INPUT.getMessage());
        }
    }

}
