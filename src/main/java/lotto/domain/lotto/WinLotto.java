package lotto.domain.lotto;

import java.util.List;

public class WinLotto extends Lotto {
    private final BonusNumber bonusNumber;

    public WinLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public LottoResult getLottoResult(Lotto lotto) {
        int numberOfSame = compareLottoNumber(lotto);
        boolean matchWithBonusNumber = compareWithBonusNumber(lotto);
        return LottoResult.getResult(numberOfSame, matchWithBonusNumber);
    }

    int compareWithLottoNumber(Lotto lotto) {
        return compareLottoNumber(lotto);
    }

    boolean compareWithBonusNumber(Lotto lotto) {
        return bonusNumber.checkLottoContainBonusNumber(lotto);
    }
}
