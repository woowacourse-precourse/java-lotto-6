package lotto.domain;

public class WinningLotto {

    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1 ~ 45 숫자만 가능합니다.";
    private static final String DUPLICATION_ERROR_MESSAGE = "[ERROR] 당첨 번호에 이미 존재하는 숫자입니다.";

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(final Lotto winningLotto, final int bonusNumber) {
        validate(bonusNumber, winningLotto);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(final int bonusNumber, final Lotto winningLotto) {
        validateNumberRange(bonusNumber);
        validateDuplication(bonusNumber, winningLotto);
    }

    private void validateNumberRange(final int bonusNumber) {
        if (LottoNumbersRule.hasOutOfRangeNumber(bonusNumber)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    private void validateDuplication(final int bonusNumber, final Lotto winningLotto) {
        if (winningLotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }

    public int countMatchingNumber(final Lotto userLotto) {
        return winningLotto.compare(userLotto);
    }

    public boolean hasBonusNumber(final Lotto userLotto) {
        return userLotto.hasNumber(bonusNumber);
    }

}
