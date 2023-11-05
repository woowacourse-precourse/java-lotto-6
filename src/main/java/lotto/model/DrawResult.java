package lotto.model;

import lotto.utils.ExceptionMessage;

public record DrawResult(Lotto lotto, Integer bonusNumber) {

    public DrawResult {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    public void validateDuplication() {
        this.lotto.getNumbers().add(bonusNumber);
        this.lotto.validateDuplication(this.lotto.getNumbers());
        this.lotto.getNumbers().remove(bonusNumber);
    }
}
