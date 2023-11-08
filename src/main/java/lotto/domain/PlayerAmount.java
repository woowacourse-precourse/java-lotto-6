package lotto.domain;

import static lotto.domain.enums.LottoConstants.MIN_PLAYER_AMOUNT;

import lotto.exception.InvalidMinPlayAmountException;
import lotto.exception.NonDivisibleException;
import lotto.util.Validator;

public class PlayerAmount {
    private static final int DIVISOR = 1000;
    private final int amount;

    public PlayerAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public PlayerAmount(String inputAmount) {
        this(Validator.validateNumeric(inputAmount));
    }

    private void validate(int amount) {
        validateDivisible(amount);
        validateMinPlayerAmount(amount);

    }

    private void validateDivisible(int money) {
        if (money % DIVISOR != 0) {
            throw new NonDivisibleException();
        }
    }

    private void validateMinPlayerAmount(int money) {
        if (money < MIN_PLAYER_AMOUNT) {
            throw new InvalidMinPlayAmountException();
        }
    }

    public int getLottoCount() {
        return amount / DIVISOR;
    }
}
