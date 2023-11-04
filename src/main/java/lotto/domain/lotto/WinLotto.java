package lotto.domain.lotto;

import lotto.domain.lottoresult.LottoResult;

public class WinLotto extends Lotto {
    private final BonusNumber bonusNumber;

    public WinLotto(Lotto lotto, BonusNumber bonusNumber) {
        super(lotto);
        this.bonusNumber = bonusNumber;
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
