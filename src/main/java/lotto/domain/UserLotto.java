package lotto.domain;

import lotto.util.ErrorMessage;

public class UserLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public UserLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        validateDuplicated();
    }

    private void validateDuplicated() {
        if (lotto.isContain(bonusNumber)){
            throw new IllegalStateException(ErrorMessage.BONUS_NUMBER_IS_DUPLICATED_MESSAGE);
        }
    }
}
