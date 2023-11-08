package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.LottoBall;

public interface LottoInput {
    int getMoneyAmount();

    Lotto getLotto();

    LottoBall getBall();

}
