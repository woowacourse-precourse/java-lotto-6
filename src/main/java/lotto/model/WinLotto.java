package lotto.model;

import lotto.utils.ExceptionMessage;

public record WinLotto(Lotto lotto, int bonusNumber) {

    public WinLotto {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_NUMBER.getMessage());
        }
        validateDuplication();
    }

    public void validateDuplication() {
        lotto.getNumbers().add(bonusNumber);
        lotto.validateDuplication(lotto.getNumbers());
        lotto.getNumbers().remove(bonusNumber);
    }
}
