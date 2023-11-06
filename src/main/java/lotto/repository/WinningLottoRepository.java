package lotto.repository;

import static lotto.settings.ErrorMessage.DUPLICATE_NUM;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

public class WinningLottoRepository {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    private WinningLottoRepository(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        //validateBonusNumInLotto(lotto,bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottoRepository of(Lotto lotto , BonusNumber bonusNumber){
        return new WinningLottoRepository(lotto,bonusNumber);
    }

//    private void validateBonusNumInLotto(Lotto lotto, BonusNumber bonusNumber) {
//        int bonusNum = bonusNumber.getNumber();
//        if(lotto.has(bonusNum)){
//            throw new IllegalArgumentException(DUPLICATE_NUM.getMessage());
//        }
//    }

    public int countMatchingNumber(Lotto buyLotto) {
        return lotto.matching(buyLotto);
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }
}
