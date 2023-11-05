package lotto.validator;

public class ValidatorPurchaseAmount {
    public ValidatorPurchaseAmount() {
    }
    private boolean isThousandWonMultiple(Purchase purchase) {
        int returnAmount = Integer.parseInt(purchase.getPurchaseAmount());
        return returnAmount % 1000 == 0;
    }
}
