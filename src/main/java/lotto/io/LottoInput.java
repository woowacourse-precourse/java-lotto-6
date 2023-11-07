package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.domain.WinningNumbers;

public interface LottoInput {
    int getMoneyAmount();

    Lotto getLotto();

    LottoBall getBall();

    WinningNumbers getWinningNumbers();
}
