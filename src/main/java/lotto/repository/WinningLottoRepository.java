package lotto.repository;

import static lotto.settings.ErrorMessage.DUPLICATE_NUM;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

public class WinningLottoRepository {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLottoRepository(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        validateBonusNumInLotto(lotto,bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumInLotto(Lotto lotto, BonusNumber bonusNumber) {
        int bonusNum = bonusNumber.getNumber();
        if(lotto.has(bonusNum)){
            throw new IllegalArgumentException(DUPLICATE_NUM.getMessage());
        }
    }

    public static WinningLottoRepository of(Lotto lotto , BonusNumber bonusNumber){
        return new WinningLottoRepository(lotto,bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }

    public int countMatchingNumber(Lotto buyLotto) {
        return lotto.matching(buyLotto);
    }
}
