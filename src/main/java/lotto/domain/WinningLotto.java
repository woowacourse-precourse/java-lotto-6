package lotto.domain;

public class WinningLotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1 ~ 45 숫자만 가능합니다.";

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(final Lotto winningLotto, final int bonusNumber) {
        validate(bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(final int bonusNumber) {
        validateNumberRange(bonusNumber);
    }

    private void validateNumberRange(final int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    private boolean isOutOfRange(final int bonusNumber) {
        return bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER;
    }

}
