package lotto.domain;

import lotto.Lotto;

public record WinningLotto(Lotto lotto, LottoNumber bonusNumber) {

    public WinningLotto {
        validateDuplicateBonusNumber(lotto, bonusNumber);
    }

    private void validateDuplicateBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
