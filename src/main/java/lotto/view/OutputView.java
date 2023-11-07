package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import javax.management.relation.RelationNotification;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.User;

public class OutputView {

    private static final String SHOW_LOTTO = "\n%d개를 구매했습니다.\n";
    private static final String STAT_MESSAGE = "\n당첨 통계\n---";
    private static final String STAT_RESULT = "%d개 일치 (%s원) - %d개";
    private static final String STAT_RESULT_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String EARNING_RATE = "총 수익률은 %s%%입니다.";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat("###,###");
    private static final DecimalFormat EARNING_FORMAT = new DecimalFormat("###,###.0");

    public void showLottos(Lottos lottos, Money money) {
        System.out.printf(SHOW_LOTTO, money.calNumberOfLotto());
        printLottos(lottos);
        printLine();
    }

    public void showLottoStatistics(Lottos lottos, User user, Money money) {
        LottoResult lottoResult = new LottoResult(lottos, user);
        System.out.println(STAT_MESSAGE);
        printLottoStatistics(lottoResult);
        printEarningRate(lottoResult.calEarningRate(money.getMoney()));
    }

    private void printEarningRate(double earningRate) {
        System.out.printf(EARNING_RATE, String.format(EARNING_FORMAT.format(earningRate)));
    }

    private void printLottoStatistics(LottoResult lottoResult) {
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.ECT))
                .forEach(rank -> System.out.println(getLottoStatistics(lottoResult, rank)));
    }

    private String getLottoStatistics(LottoResult lottoResult, Rank rank) {
        if (rank == Rank.FIVE_BONUS) {
            return String.format(STAT_RESULT_BONUS, rank.getMatchingNumber(),
                    MONEY_FORMAT.format(rank.getPrize()), lottoResult.getResult(rank));
        }
        return String.format(STAT_RESULT, rank.getMatchingNumber(),
                MONEY_FORMAT.format(rank.getPrize()), lottoResult.getResult(rank));
    }

    private void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private void printLine() {
        System.out.println();
    }

}
