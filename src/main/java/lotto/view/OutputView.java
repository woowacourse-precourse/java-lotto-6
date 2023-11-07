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

    public void printLottos(List<Lotto> lottos) {
        for(Lotto lotto : lottos) {
            String lottoNumber = StringHandler.joinBy(lotto.getNumbers(), DELIMITER);
            System.out.printf(ARRAY_BEGIN_STRING + lottoNumber + ARRAY_END_STRING);
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
        System.out.printf("당첨 통계" + System.lineSeparator() + "---");
    }

    public void printRateOfReturn(int lottosCount, long totalPrize) {
        double purchaseMoney = lottosCount * LOTTO_AMOUNT;
        double profit = totalPrize - purchaseMoney;

        double rateOfReturn = (profit / purchaseMoney) * PERCENT_CHANGER;

        System.out.printf("총 수익률은 %.1f%%입니다.",rateOfReturn);
    }

}
