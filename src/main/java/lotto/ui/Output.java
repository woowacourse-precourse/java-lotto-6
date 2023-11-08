package lotto.ui;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningStatus;

public interface Output {
    void printLottoPriceRequest();

    void printPurchasedLotto(List<Lotto> lottos);

    void printWinningNumbersRequest();

    void printError(String message);

    void printBonusNumberRequest();

    void printWinningStatus(WinningStatus winningStatus);

    void printRateOfReturn(double rateOfReturn);
}
