package lotto.model;

import static lotto.message.ErrorMessage.DUPLICATE_ERROR_MESSAGE;

public record BonusNumber(
        int bonusNumber
) {

    public void validateIsDuplicate(Lotto winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
