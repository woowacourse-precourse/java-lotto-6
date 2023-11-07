package lotto.view;

import java.util.List;
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
    private static final String START_ERROR_MESSAGE = "[ERROR] ";

    public void printLottos(List<Lotto> lottos) {
        for(Lotto lotto : lottos) {
            String lottoNumber = StringHandler.joinBy(lotto.getNumbers(), DELIMITER);
            System.out.print(ARRAY_BEGIN_STRING + lottoNumber + ARRAY_END_STRING);
        }
    }

    public void printBuyMessage(int lottosCount) {
        System.out.printf("%d개를 구매했습니다.", lottosCount);
    }

    public void printResultStatistics(List<Integer> result) {
        printResultStatisticsPhrases();
        int i = 0;
        for(Rank rank : Rank.values()) {
            if(rank == Rank.ZERO) {
                continue;
            }
            System.out.printf(rank.getMessage() + RESULT_COUNT, result.get(i));
            i++;
        }
    }

    public void printResultStatisticsPhrases() {
        System.out.print("당첨 통계" + System.lineSeparator() + "---");
    }

    public void printRateOfReturn(int lottoCount, long totalPrize) {
        double rateOfReturn = calculateRateOfReturn(lottoCount, totalPrize);
        System.out.printf("총 수익률은 %.1f%%입니다.",rateOfReturn);
    }

    public double calculateRateOfReturn(int lottoCount, long totalPrize) {
        double purchaseMoney = lottoCount * LOTTO_AMOUNT;
        return (totalPrize / purchaseMoney) * PERCENT_CHANGER;
    }

    public void printError(String errorMessage) {
        System.out.println(START_ERROR_MESSAGE + errorMessage);
    }
}
