package lotto.io;

import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;

public interface LottoInput {
    int getMoneyAmount();

    Lotto getLotto();

    LottoBall getBall();

}
