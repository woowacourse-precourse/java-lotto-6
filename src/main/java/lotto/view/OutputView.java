package lotto.view;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.User;

public class OutputView {

    private static final String SHOW_LOTTO = "\n%d개를 구매했습니다.\n";
    private static final String STAT_MESSAGE = "\n당첨 통계\n---";
    private static final String STAT_RESULT = "%d개 일치 (%s원) - %d개\n";
    private static final String STAT_RESULT_BONUS = "%d개 일치, 보너스 볼 일치 (%s)원 - %d개\n";
    private static final String EARNING = "총 수익률은 %.1f입니다.";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat("###,###");

    public void showLottos(Lottos lottos, Money money) {
        System.out.printf(SHOW_LOTTO, money.calNumberOfLotto());
        lottos.showLottos();
        printLine();
    }

    public void showLottoStatistics(Rank rank, Lottos lottos, User user) {
        Map<Rank, Integer> rankResult = lottos.saveRankResult(user);
        rankResult.remove(Rank.ECT);
        System.out.println(STAT_MESSAGE);
        rankResult.forEach((key, value) -> {
            if (rank == Rank.FIVE_BONUS) {
                System.out.printf(STAT_RESULT_BONUS, rank.getMatchingNumber(),
                        MONEY_FORMAT.format(rank.getPrize()), rankResult.get(rank));
            } else {
                System.out.printf(STAT_RESULT, rank.getMatchingNumber(),
                        MONEY_FORMAT.format(rank.getPrize()), rankResult.get(rank));
            }
        });
    }

    public void printLine() {
        System.out.println();
    }

}
