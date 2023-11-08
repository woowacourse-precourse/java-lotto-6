package lotto.domain;

import static lotto.message.ErrorMessages.INVALID_AMOUNT_FORMAT;
import static lotto.message.ErrorMessages.INVALID_AMOUNT_RANGE;

public record PlayerBuyPrice(String amount) {

    private static int MIN_AMOUNT = 1_000;
    private static int MAX_AMOUNT = 10_000_000;

    public PlayerBuyPrice {
        validateCharacterFromAmount(amount);
        validateRangeFromAmount(amount);
    }

    private void validateCharacterFromAmount(String input) {
        for (int idx = 0; idx < input.length(); idx++) {
            if (!Character.isDigit(input.charAt(idx))){
                throw new IllegalArgumentException(INVALID_AMOUNT_FORMAT.getMessage());
            }
        }
    }

    private void validateRangeFromAmount(String input) {
        int buyAmount = Integer.parseInt(input);
        if (buyAmount < MIN_AMOUNT || buyAmount > MAX_AMOUNT){
            throw new IllegalArgumentException(INVALID_AMOUNT_RANGE.getMessage());
        }
    }
}
