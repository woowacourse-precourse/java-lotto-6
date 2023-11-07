package lotto.domain;

import lotto.domain.db.PurchaseLotto;
import lotto.domain.db.WinningLotto;

public class BonusFlag {
    public static boolean flag(PurchaseLotto pLotto, WinningLotto wLotto) {
        if (pLotto.getLottoNumbers().contains(wLotto.getBonusNumber())) {
            return true;
        }
        return false;
    }
}
