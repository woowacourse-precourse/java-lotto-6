package lotto.domain;

import static lotto.constants.Constant.*;

public class Player {
    private static int amount;

    public Player(String amount) {
        int amountNum = validateNumber(amount);
        validateAmount(amountNum);
        this.amount = amountNum;
    }

    public int calculateLottoCount() {
        return amount/LOTTO_PRICE;
    }

    public void validateAmount(int amount) {
        validateNatural(amount);
        validateDivisible(amount);
    }

    private static int validateNumber(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateNatural(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(NATURAL_ERROR_MESSAGE);
        }
    }

    private void validateDivisible(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(DIVISIBLE_ERROR_MESSAGE);
        }
    }

}
