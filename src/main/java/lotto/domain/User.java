package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.ErrorMessages;

public class User {
    public static final int DIVIDE_NUMBER = 1000;

    private long purchaseAmount;
    private List<Integer> numbers;

    public void setPurchaseAmount(String purchaseAmount) throws Exception {
        try {
            validateLong(purchaseAmount);
            validateDivide(purchaseAmount);
            this.purchaseAmount = Long.parseLong(purchaseAmount);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void setWinnerNumbers(String number) throws Exception {
        List<Integer> numbers = new ArrayList<>();
        try {
            String[] numberTokens = number.split(",");
            for (int i = 0; i < numberTokens.length; i++) {
                numbers.add(validateInt(numberTokens[i]));
            }
            validateSize(numbers.size());
            this.numbers = numbers;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }

    private void validateSize(int size) {
        if (size != 6) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_SIZE.getMessage());
        }
    }

    private Integer validateInt(String numberToken) {
        try {
            int number = Integer.parseInt(numberToken);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LONG.getMessage());
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
