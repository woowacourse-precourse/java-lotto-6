package lotto.view;

import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.constant.ViewMessage;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.util.StringHandler;

public class OutputView {

    private static final String DELIMITER = ", ";
    private static final String ARRAY_BEGIN_STRING = "[";
    private static final String ARRAY_END_STRING = "]";
    private static final String RESULT_COUNT = "%d개";
    private static final double PERCENT_CHANGER = 100.0;
    private static final double LOTTO_AMOUNT = 1000.0;

    public void printLottos(List<Lotto> lottos, int lottosCount) {
        printBuyMessage(lottosCount);
        for(Lotto lotto : lottos) {
            String lottoNumber = StringHandler.joinBy(lotto.getNumbers(), DELIMITER);
            System.out.println(ARRAY_BEGIN_STRING + lottoNumber + ARRAY_END_STRING);
        }
    }

    private void printBuyMessage(int lottosCount) {
        System.out.printf(ViewMessage.BUY_MESSAGE.getMessage() + System.lineSeparator(), lottosCount);
    }

    public void printResultStatistics(List<Integer> result) {
        printStatisticsResultPhrases();
        int i = 0;
        for (Rank rank : Rank.values()) {
            if (rank == Rank.ZERO) {
                continue;
            }
            System.out.printf(rank.getMessage() + RESULT_COUNT + System.lineSeparator(), result.get(i));
            i++;
        }
    }

    private void printStatisticsResultPhrases() {
        System.out.print(ViewMessage.STATISTICS_RESULT_MESSAGE.getMessage());
    }

    public void printRateOfReturn(int lottoCount, long totalPrize) {
        double rateOfReturn = calculateRateOfReturn(lottoCount, totalPrize);
        System.out.printf(ViewMessage.RATE_OF_RETURN_MESSAGE.getMessage(), rateOfReturn);
    }

    public double calculateRateOfReturn(int lottoCount, long totalPrize) {
        double purchaseMoney = lottoCount * LOTTO_AMOUNT;
        return (totalPrize / purchaseMoney) * PERCENT_CHANGER;
    }

    public void printError(String errorMessage) {
        System.out.println(ExceptionMessage.ERROR_FORMAT_MESSAGE.getMessage() + errorMessage);
    }
}
