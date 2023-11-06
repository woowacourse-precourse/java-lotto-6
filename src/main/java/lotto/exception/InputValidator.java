package lotto.exception;

public class InputValidator {

    public static int checkPurchaseAmountInput(int purchaseAmount){

        int res = purchaseAmount % 1000;
        if (res != 0){
            throw new IllegalArgumentException();
        }
        int lottoCnt = purchaseAmount/1000;

        return lottoCnt;
    }
}
