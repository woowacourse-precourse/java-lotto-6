package lotto.domain.lotto;

import java.util.List;

public class WinLotto extends Lotto {
    private final BonusNumber bonusNumber;

    public WinLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public int compareWithLottoNumber(Lotto lotto) {
        return compareLottoNumber(lotto);
    }

    public boolean compareWithBonusNumber(Lotto lotto) {
        return bonusNumber.checkLottoContainBonusNumber(lotto);
    }
}
