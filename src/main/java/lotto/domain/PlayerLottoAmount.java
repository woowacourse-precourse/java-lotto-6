package lotto.domain;

import lotto.view.ExceptionMessage;

public class PlayerLottoAmount {

    private static final int LOTTO_MIN_AMOUNT = 1000;
    private final int amount;

    public PlayerLottoAmount(String amount) {
        int playerPrice = validateNumber(amount);
        validateNumberDivide(playerPrice);
        this.amount = playerPrice;
    }

    private static void validateNumberDivide(int playerPrice) {
        if (playerPrice % 1000 != 0) {
            ExceptionMessage.numberNotDivideException();
            throw new IllegalArgumentException();
        }

    }

    private static int validateNumber(String amount) throws IllegalArgumentException {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            ExceptionMessage.numberException();
            throw new IllegalArgumentException();
        }

    }

    public int calculateLottoCount() {
        return amount / LOTTO_MIN_AMOUNT;
    }
}
