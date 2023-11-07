package lotto.model;

import static lotto.utils.ErrorMessage.*;

public class Deposit {
    private static final Integer DIVISION_UNIT = 1_000;
    private static final Integer MIN_AMOUNT = 1_000;
    private static final Integer MAX_AMOUNT = 100_000;

    private final Integer amount;

    public Deposit(String amount) {
        validateDeposit(amount);
        this.amount = Integer.parseInt(amount);
    }

    private void validateDeposit(String amount) {
        int depositAmount;
        try {
            depositAmount = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DEPOSIT_NOT_A_NUMBER.getDescription());
        }
        if (depositAmount % DIVISION_UNIT != 0) {
            throw new IllegalArgumentException(DEPOSIT_NOT_A_UNIT_OF_THOUSAND.getDescription());
        }
        if (depositAmount > MAX_AMOUNT || depositAmount < MIN_AMOUNT) {
            throw new IllegalArgumentException(DEPOSIT_OUT_OF_RANGE.getDescription());
        }
    }

    public Integer calculateBuyableLottoAmount() {
        return amount / DIVISION_UNIT;
    }

    public String calculateEarningsRate(Integer earnings) {
        return String.valueOf(Math.round(earnings * 1000.0 / amount) / 10.0);
    }
}
