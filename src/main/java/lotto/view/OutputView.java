package lotto.view;

import lotto.constant.LottoWinningValue;
import lotto.domain.Lotto;
import lotto.domain.RateOfReturn;
import lotto.domain.UserLottos;

import java.util.Map;

public class OutputView {
    private static final int HIGHEST_RANK = LottoWinningValue.values()[0].getRank();
    private static final int LOWEST_RANK = LottoWinningValue.values()[LottoWinningValue.values().length - 1].getRank();

    public void printNumberOfPurchase(int num) {
        System.out.printf("\n%d개를 구매했습니다.\n", num);
    }

    // 발행된 모든 로또 리스트 출력
    public void printAllLottoNumbersList(UserLottos allLottoList) {
        for (Lotto lotto : allLottoList.getLottos()) {
            printLottoNumbersList(lotto);
        }
        System.out.println();
    }

    // 하나의 로또 리스트 출력
    private void printLottoNumbersList(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    // 당첨 통계 출력
    public void printWinningStatistics(Map<Integer, Integer> winningCnt, RateOfReturn rateOfReturn) {
        System.out.println("\n당첨 통계\n---");

        for (int i = LOWEST_RANK; i >= HIGHEST_RANK; i--) {
            String winnings = LottoWinningValue.valueOfRank(i).getWinningsPhrase(); // 해당 등수 당첨 문구
            int cnt = winningCnt.getOrDefault(i, 0); // 해당 등수 당첨 개수

            System.out.printf("%s - %d개\n", winnings, cnt);
        }

        printRateOfReturn(rateOfReturn);
    }

    private void printRateOfReturn(RateOfReturn rateOfReturn) {
        System.out.printf("총 수익률은 %s입니다.", rateOfReturn.getRateOfReturn());
    }
}
