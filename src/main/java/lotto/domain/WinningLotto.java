package lotto.domain;

import lotto.constant.message.ExceptionMessage;

public class WinningLotto {

    private final Lotto lotto;
    private BonusNumber bonusNumber;

    public WinningLotto(final Lotto lotto) {
        this.lotto = lotto;
    }

    public void updateBonusNumber(final Integer value) {
        validateDuplicateNumber(value);
        this.bonusNumber = new BonusNumber(value);
    }

    private void validateDuplicateNumber(final Integer value) {
        if (lotto.getNumbers().contains(value)) {
            throw new IllegalArgumentException(ExceptionMessage.HAS_DUPLICATE_NUMBER_ON_LOTTO.toMessage());
        }
    }

    public Lotto toLotto() {
        return lotto;
    }

    public BonusNumber toBonusNumber() {
        return bonusNumber;
    }
}
