package lotto.view;

import lotto.constant.LottoWinning;
import lotto.domain.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String NUMBER_OF_PURCHASE = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS = "당첨 통계\n---";
    private static final String WINNING_RESULT = "%s - %d개\n";
    private static final String RATE_OF_RETURN = "총 수익률은 %d%%입니다.";

    private static final int HIGHEST_RANK = LottoWinning.values()[0].getRank();
    private static final int LOWEST_RANK = LottoWinning.values()[LottoWinning.values().length - 1].getRank();


    public void printNumberOfPurchase(int num) {
        System.out.printf(NUMBER_OF_PURCHASE, num);
    }

    public void printAllLottoNumbersList(List<Lotto> allLottoList) {
        for (Lotto lottoList : allLottoList) {
            printLottoNumbersList(lottoList);
        }
    }

    private void printLottoNumbersList(Lotto lottoList) {
        System.out.println(lottoList);
    }

    public void printWinningStatistics(Map<Integer, Integer> winningCnt, int rateOfReturn) {
        System.out.println(WINNING_STATISTICS);

        for (int i = HIGHEST_RANK; i <= LOWEST_RANK; i++) {
            String winnings = LottoWinning.valueOfRank(i).getWinnings();
            int cnt = winningCnt.get(i);

            System.out.printf(WINNING_RESULT, winnings, cnt);
        }

        printRateOfReturn(rateOfReturn);
    }

    private void printRateOfReturn(int rateOfReturn) {
        System.out.printf(RATE_OF_RETURN, rateOfReturn);
    }
}
