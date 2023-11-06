package lotto.domain;

import lotto.ErrorMessages;

public class User {
    public static final int DIVIDE_NUMBER = 1000;
    private long purchaseAmount;

    public long getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(String purchaseAmount) throws Exception {
        try {
            validateLong(purchaseAmount);
            validateDivide(purchaseAmount);
            this.purchaseAmount = Long.parseLong(purchaseAmount);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void validateDivide(String purchaseAmount) {
        long number = Long.parseLong(purchaseAmount);
        if (number % DIVIDE_NUMBER != 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DIVIDE_NUMBER.getMessage());
        }
    }

    private void validateLong(String purchaseAmount) {
        try {
            long number = Long.parseLong(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LONG.getMessage());
        }
    }
}
