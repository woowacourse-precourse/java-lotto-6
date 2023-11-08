package lotto.repository;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

public class WinningLottoRepository {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    private WinningLottoRepository(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottoRepository of(Lotto lotto , BonusNumber bonusNumber){
        return new WinningLottoRepository(lotto,bonusNumber);
    }

    public int countMatchingNumber(Lotto buyLotto) {
        return lotto.matching(buyLotto);
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }
}
