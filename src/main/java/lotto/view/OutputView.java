package lotto.view;

import lotto.domain.game.dto.PrizesStatisticsInfo;
import lotto.domain.game.dto.PurchasedLottosInfo;

public interface OutputView {
    void printPurchasedLottos(PurchasedLottosInfo purchasedLottosInfo);

    void printPrizesStatistics(PrizesStatisticsInfo prizesStatisticsInfo);
    void printMessage(String message);

    void printErrorMessage(String message);
}
