package lotto.domain;

import lotto.validator.WinningLottoValidator;

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
        WinningLottoValidator.validate(bonusNumber, winningLotto);
    }

    public int countMatchingNumber(final Lotto userLotto) {
        return winningLotto.compare(userLotto);
    }

    public boolean hasBonusNumber(final Lotto userLotto) {
        return userLotto.hasNumber(bonusNumber);
    }

}
