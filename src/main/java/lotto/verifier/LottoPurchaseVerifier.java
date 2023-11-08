package lotto.verifier;

import lotto.exception.ExceptionMsg;

public class LottoPurchaseVerifier {
    private final String purchaseAmount;

    public LottoPurchaseVerifier(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        verifyNull();
        verifyInt();
    }

    public void verifyNull() {
        if (this.purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMsg.NULL_INPUT.getMessage());
        }
    }

    public void verifyInt(){
        int purchaseAmountInt;
        try {
             purchaseAmountInt = Integer.parseInt(purchaseAmount);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(ExceptionMsg.NOT_INT_INPUT.getMessage());
        }
        if(purchaseAmountInt % 1000 != 0){
            throw new IllegalArgumentException(ExceptionMsg.NOT_MULTIPLE_THOUSAND.getMessage());
        }

    }

}
