package lotto.model;

import lotto.constant.ErrorMessage;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateDuplication(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
    
    public void validateDuplication(Lotto winningLottoTicket, int bonusNumber) {
        if (winningLottoTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_MESSAGE.getMessage());
        }
    }
}
