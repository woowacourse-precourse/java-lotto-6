package lotto.global.view;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.GameResult;
import lotto.domain.Money;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Score;

public class OutputView {

    private static final String ENTER = System.lineSeparator();
    private static final String PURCHASED_COUNT_MESSAGE = ENTER + "%d개를 구매했습니다.";
    private static final String WINNING_STATS_MESSAGE = ENTER + "당첨 통계";
    private static final String DIVIDER_MESSAGE = "---";
    private static final String MATCH_THREE_PRIZE_COUNT_MESSAGE = "3개 일치 (%,d원) - %d개\n";
    private static final String MATCH_FOUR_PRIZE_COUNT_MESSAGE = "4개 일치 (%,d원) - %d개\n";
    private static final String MATCH_FIVE_PRIZE_COUNT_MESSAGE = "5개 일치 (%,d원) - %d개\n";
    private static final String MATCH_FIVE_WITH_BONUS_PRIZE_COUNT_MESSAGE = "5개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String MATCH_SIX_PRIZE_COUNT_MESSAGE = "6개 일치 (%,d원) - %d개\n";
    private static final String TOTAL_RATE_OF_RETURN_MESSAGE = "총 수익률은 %,.1f%%입니다.";

    private OutputView() {
    }

    public static void printPurchaseCount(int count) {
        System.out.println(String.format(PURCHASED_COUNT_MESSAGE, count));
    }

    public static void printPurchaseLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            //리팩토링 필요
            List<Integer> sortedLotto = lotto.getSortedLotto();
            System.out.printf("%s%n", sortedLotto);
        }
    }

    public static void printWinningStats(GameResult gameResult, Money money) {
        System.out.println(WINNING_STATS_MESSAGE);
        System.out.println(DIVIDER_MESSAGE);
        printMatchPrizeAndCount(gameResult);
        System.out.printf(TOTAL_RATE_OF_RETURN_MESSAGE, gameResult.calculateRateOfReturn(money));
    }

    private static void printMatchPrizeAndCount(GameResult gameResult) {
        Map<Score, Integer> lottoResults = gameResult.getLottoResults();
        Map<Score, String> messageForms = new LinkedHashMap<>();
        messageForms.put(Score.FIFTH, MATCH_THREE_PRIZE_COUNT_MESSAGE);
        messageForms.put(Score.FOURTH, MATCH_FOUR_PRIZE_COUNT_MESSAGE);
        messageForms.put(Score.THIRD, MATCH_FIVE_PRIZE_COUNT_MESSAGE);
        messageForms.put(Score.SECOND, MATCH_FIVE_WITH_BONUS_PRIZE_COUNT_MESSAGE);
        messageForms.put(Score.FIRST, MATCH_SIX_PRIZE_COUNT_MESSAGE);

        for (Score score : messageForms.keySet()) {
            int count = lottoResults.getOrDefault(score, 0);
            System.out.printf(messageForms.get(score), score.getPrize(), count);
        }
    }

}
