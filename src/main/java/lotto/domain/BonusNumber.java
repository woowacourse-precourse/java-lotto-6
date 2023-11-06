package lotto.domain;

import lotto.util.ErrorMessage;

public record BonusNumber(int number) {

    public BonusNumber {
        validateNumberInRange(number);
    }

    public BonusNumber(String number) {
        this(parseBonusNumber(number));
    }

    private static int parseBonusNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_BONUS_NUMBER.getMessage());
        }
    }

    private void validateNumberInRange(int bonusNumber) {
        if (bonusNumber < LottoNumberRule.MIN.number()
                || bonusNumber > LottoNumberRule.MAX.number()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_IN_RANGE.getMessage());
        }
    }
}
