package lotto.domain;

import java.util.Objects;

public class LottoPurchase {
    private static final int AMOUNT_UNIT = 1000;
    private static final String NON_ZERO_AMOUNT_ERROR_MESSAGE = "[ERROR] 0보다 큰 숫자여야 합니다.";
    private static final String NOT_PROPER_UNIT_ERROR_MESSAGE = "[ERROR] 1000원 단위의 숫자여야 합니다.";
    
    private final int amount;
    
    public LottoPurchase(int amount) {
        validateNonZero(amount);
        validateAmountUnit(amount);
        this.amount = amount;
    }
    
    public int calculateTicketCount() {
        return amount / AMOUNT_UNIT;
    }
    
    private void validateNonZero(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException(NON_ZERO_AMOUNT_ERROR_MESSAGE);
        }
    }
    
    private void validateAmountUnit(int amount) {
        if (amount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(NOT_PROPER_UNIT_ERROR_MESSAGE);
        }
    }
    
    public int getAmount() {
        return amount;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoPurchase that = (LottoPurchase) o;
        return amount == that.amount;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
