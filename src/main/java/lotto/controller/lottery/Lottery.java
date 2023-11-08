package lotto.controller.lottery;

import lotto.domain.Lotto;
import lotto.lottoenum.LottoRanking;

public interface Lottery {
    LottoRanking lotteryCheck(Lotto answer,Lotto myNumbers, int bonus);
}
