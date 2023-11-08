package lotto.domain.win;

import static lotto.option.Error.ONE_TO_FORTY_FIVE;

import lotto.option.GameOption;

public record Bonus(int number) {
    public Bonus {
        validate(number);
    }

    private void validate(int bonusNumber) {
        validateRange(bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < GameOption.LOTTO_MIN_NUMBER.getNumber()
                || bonusNumber > GameOption.LOTTO_MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ONE_TO_FORTY_FIVE.getMessage());
        }
    }
}
