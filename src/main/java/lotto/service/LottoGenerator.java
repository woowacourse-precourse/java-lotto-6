package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class LottoGenerator {
    private static final int LOTTO_SIZE = 6;

    public static Lotto generateAutoLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_SIZE));
    }
    public static WinningLotto generateWinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }
}
