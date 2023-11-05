package lotto.verifier;

import lotto.exception.ExceptionMsg;

public class LottoPurchaseVerifier {
    private String purchaseAmount;

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
        try {
            int purchaseAmountInt = Integer.parseInt(purchaseAmount);
            if(purchaseAmountInt % 1000 != 0){
                throw new IllegalArgumentException(ExceptionMsg.NOT_MULTIPLE_THOUSAND.getMessage());
            }
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(ExceptionMsg.NOT_INT_INPUT.getMessage());

        }
    }

}
