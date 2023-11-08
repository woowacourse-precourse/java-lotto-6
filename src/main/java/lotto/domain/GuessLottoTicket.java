package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class GuessLottoTicket {

    private final Lotto lotto;

    public GuessLottoTicket() {
        lotto = this.createWinningLottoNumber();
    }

    public Lotto getLotto() {
        return lotto;
    }

    private Lotto createWinningLottoNumber() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

}
