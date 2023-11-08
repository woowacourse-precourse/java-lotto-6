package lotto.domain.win;

import static lotto.Option.ErrorMessage.ONE_TO_FORTY_FIVE;

import lotto.Option.GameOption;

public record Bonus(int bonusNumber) {
    public Bonus {
        validate(bonusNumber);
    }

    private void validate(int bonusNumber) {
        validateRange(bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < GameOption.LOTTO_MIN_NUMBER.getNumber()
                || bonusNumber > GameOption.LOTTO_MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ONE_TO_FORTY_FIVE.getErrorMessage());
        }
    }
}
