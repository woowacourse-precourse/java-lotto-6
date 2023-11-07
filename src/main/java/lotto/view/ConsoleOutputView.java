package lotto.view;

import lotto.constants.ViewConsts;
import lotto.domain.game.dto.PrizesStatisticsInfo;
import lotto.domain.game.dto.PurchasedLottosInfo;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printPurchasedLottos(final PurchasedLottosInfo purchasedLottosInfo) {
        printMessage(ViewConsts.OUTPUT_PURCHASED_LOTTO_COUNT.getFormattedMessage(purchasedLottosInfo.count()));
        purchasedLottosInfo.lottoNumbers()
                .forEach(lottoNumbers -> printMessage(ViewConsts.OUTPUT_PURCHASED_LOTTO_NUMBERS.getFormattedMessage(lottoNumbers.toArray())));
    }

    @Override
    public void printPrizesStatistics(final PrizesStatisticsInfo prizesStatisticsInfo) {
        printMessage(ViewConsts.OUTPUT_STATISTICS.getFormattedMessage(
                prizesStatisticsInfo.prizeCounts().get(0),
                prizesStatisticsInfo.prizeCounts().get(1),
                prizesStatisticsInfo.prizeCounts().get(2),
                prizesStatisticsInfo.prizeCounts().get(3),
                prizesStatisticsInfo.prizeCounts().get(4),
                prizesStatisticsInfo.profitRate()
        ));
    }

    @Override
    public void printMessage(final String message) {
        System.out.println(message);
    }

    @Override
    public void printErrorMessage(final String message) {
        printMessage(ViewConsts.OUTPUT_ERROR_PREFIX.getMessage() + message);
    }
}
