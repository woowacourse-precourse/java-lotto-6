package lotto.domain;

import lotto.enums.LottoNumbers;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (!LottoNumbers.contains(bonusNumber)
                || lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
