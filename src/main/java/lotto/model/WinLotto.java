package lotto.model;

import static lotto.model.enums.ErrorMessage.DUPLICATED_NUMBER_MESSAGE;

public class WinLotto {
    private final Lotto winLotto;
    private final int bonusNumber;

    public WinLotto(Lotto winLotto, int bonusNumber) {
        checkDuplicateNumber(winLotto, bonusNumber);
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    private void checkDuplicateNumber(Lotto winLotto, int bonusNumber) {
        if (winLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_MESSAGE.getMessage());
        }
    }
}
