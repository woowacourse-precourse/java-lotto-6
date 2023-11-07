package lotto.io;

import java.util.List;
import lotto.domain.WinningNumbers;

public interface LottoInput {
    long getMoneyAmount();
    WinningNumbers getWinningNumbers();
}
