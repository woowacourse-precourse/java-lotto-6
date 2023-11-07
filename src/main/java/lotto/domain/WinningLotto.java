package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class WinningLotto {

    private final Lotto lotto;

    public WinningLotto() {
        lotto = this.createWinningLottoNumber();
    }

    public Lotto getLotto() {
        return lotto;
    }


    private Lotto createWinningLottoNumber() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

}
