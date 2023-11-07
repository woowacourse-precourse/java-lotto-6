package lotto.view;

import lotto.constant.LottoWinningValue;
import lotto.domain.Lotto;
import lotto.domain.RateOfReturn;
import lotto.domain.UserLottos;

import java.util.Map;

public class OutputView {
    private static final String NUMBER_OF_PURCHASE = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS = "\n당첨 통계\n---";
    private static final String WINNING_RESULT = "%s - %d개\n";
    private static final String RATE_OF_RETURN = "총 수익률은 %s입니다.";

    private static final int HIGHEST_RANK = LottoWinningValue.values()[0].getRank();
    private static final int LOWEST_RANK = LottoWinningValue.values()[LottoWinningValue.values().length - 1].getRank();


    public void printNumberOfPurchase(int num) {
        System.out.printf(NUMBER_OF_PURCHASE, num);
    }

    public void printAllLottoNumbersList(UserLottos allLottoList) {
        for (Lotto lotto : allLottoList.getLottos()) {
            printLottoNumbersList(lotto);
        }
        System.out.println();
    }

    private void printLottoNumbersList(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public void printWinningStatistics(Map<Integer, Integer> winningCnt, RateOfReturn rateOfReturn) {
        System.out.println(WINNING_STATISTICS);

        for (int i = LOWEST_RANK; i >= HIGHEST_RANK; i--) {
            String winnings = LottoWinningValue.valueOfRank(i).getWinningsPhrase();
            int cnt = winningCnt.getOrDefault(i, 0);

            System.out.printf(WINNING_RESULT, winnings, cnt);
        }

        printRateOfReturn(rateOfReturn);
    }

    private void printRateOfReturn(RateOfReturn rateOfReturn) {
        System.out.printf(RATE_OF_RETURN, rateOfReturn.getRateOfReturn());
    }
}
