package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import lotto.lotto.Lotto;
import lotto.money.Money;
import lotto.ranking.Ranking;
import lotto.statistics.Statistics;

public class OutputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUY_LOTTOS = "개를 구매했습니다.";
    private static final String INPUT_WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String RANK_RESULT_FORMAT = "%d개 일치 (%s원) - %d개\n";
    private static final String SECOND_RANK_RESULT_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String PROFIT_RESULT_FORMAT = "총 수익률은 %s%%입니다.\n";
    private static final String STATISTICS_TITLE = "당첨 통계";
    private static final String STATISTICS_DIVIDER = "---";
    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getInstance();

    public static void inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
    }

    public static void buyLottos(Money money, List<Lotto> lottos) {
        System.out.println();
        System.out.println(money.getLottoCount() + BUY_LOTTOS);
        lottos.forEach(System.out::println);
    }

    public static void inputWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO_MESSAGE);
    }

    public static void inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public static void printError(IllegalArgumentException e) {
        System.out.println(ERROR_MESSAGE + e.getMessage());
    }

    public static void showStatists(Statistics statistics, Money money) {
        System.out.println(STATISTICS_TITLE);
        System.out.println(STATISTICS_DIVIDER);
        Map<Ranking, Integer> result = statistics.getStatistics();
        for (Ranking ranking : Ranking.values()) {
            showRankingResult(ranking, result);
        }
        showProfit(statistics, money);
    }

    private static void showProfit(Statistics statistics, Money money) {
        Double profit = statistics.calculateProfit(money);
        System.out.printf(PROFIT_RESULT_FORMAT, NUMBER_FORMAT.format(profit));
    }

    private static void showRankingResult(Ranking ranking, Map<Ranking, Integer> result) {
        String price = NUMBER_FORMAT.format(ranking.getPrice());
        if (ranking.equals(Ranking.NOTHING)) {
            return;
        } else if (ranking.equals(Ranking.SECOND)) {
            System.out.printf(SECOND_RANK_RESULT_FORMAT, ranking.getMatchCount(), price, result.get(ranking));
            return;
        }
        System.out.printf(RANK_RESULT_FORMAT, ranking.getMatchCount(), price, result.get(ranking));
    }
}
