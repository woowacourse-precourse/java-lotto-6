package lotto.view;

import lotto.constant.LottoInformation;
import lotto.domain.Lotto;
import lotto.constant.LottoPrize;
import lotto.domain.User;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String BUY_LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_WINNING_STATS_MESSAGE = "당첨 통계";
    private static final String DASH_SEPARATOR_MESSAGE = "---";
    private static final String LOTTO_WINNING_RANK_COUNT_MESSAGE = "%d개 일치 (%,d원) - %d개\n";
    private static final String LOTTO_WINNING_RANK_BONUS_COUNT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String TOTAL_PROFIT_MARGIN_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public void printPurchaseLotto(User user) {
        printPurchaseLottoAmount(user.getMoney());
        printLottoNumbers(user.getLottos());
        System.out.println();
    }

    private void printPurchaseLottoAmount(int money) {
        System.out.println(money / LottoInformation.MONEY_UNIT.getNumber() + BUY_LOTTO_AMOUNT_MESSAGE);
    }

    private void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public void printTotalLottoResult(Map<Integer, Integer> countTotalLottoPrizes, double profitMargin) {
        System.out.println(LOTTO_WINNING_STATS_MESSAGE);
        System.out.println(DASH_SEPARATOR_MESSAGE);
        printRankResults(countTotalLottoPrizes);
        System.out.printf(TOTAL_PROFIT_MARGIN_MESSAGE, profitMargin);
    }

    private void printRankResults(Map<Integer, Integer> countTotalLottoPrizes) {
        for (Integer rank : countTotalLottoPrizes.keySet()) {
            long money = LottoPrize.findPrizeMoney(rank);
            int rankCount = countTotalLottoPrizes.get(rank);
            if (rank == 50) {
                rank = 5;
                System.out.printf(LOTTO_WINNING_RANK_BONUS_COUNT_MESSAGE, rank, money, rankCount);
                continue;
            }
            System.out.printf(LOTTO_WINNING_RANK_COUNT_MESSAGE, rank, money, rankCount);
        }
    }
}
