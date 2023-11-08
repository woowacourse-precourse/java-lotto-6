package lotto.view.output;

import static lotto.domain.ranking.LottoRanking.FIFTH;
import static lotto.domain.ranking.LottoRanking.FIRST;
import static lotto.domain.ranking.LottoRanking.FOURTH;
import static lotto.domain.ranking.LottoRanking.SECOND;
import static lotto.domain.ranking.LottoRanking.THIRD;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.controller.dto.PurchaseResultDto;
import lotto.controller.dto.StatisticDto;
import lotto.domain.ranking.LottoRanking;

public class OutputView {

    private static final String PURCHASE_AMOUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.\n";
    private static final String LOTTO_MESSAGE_FORMAT = "[%s]";
    private static final String STATISTICS_TITLE_MESSAGE = "당첨 통계\n---";
    private static final String RANK_MATCH_MESSAGE_FORMAT = "%s (%s원) - %d개\n";
    private static final String RANK_CONDITION_MESSAGE_FORMAT = "%d개 일치";
    private static final String BONUS_BALL_CONDITION_MESSAGE = ", 보너스 볼 일치";
    private static final String EARNING_RATE_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.";

    private static final String DELIMITER = ", ";
    private static final List<LottoRanking> WINNING_RANKINGS
        = List.of(FIRST, SECOND, THIRD, FOURTH, FIFTH);

    private OutputView() {
    }

    public static void printPurchaseResult(PurchaseResultDto dto) {
        System.out.printf(PURCHASE_AMOUNT_MESSAGE_FORMAT, dto.amount());

        dto.lottos().forEach((lotto) ->
            System.out.println(formatLotto(lotto))
        );

        System.out.println();
    }

    private static String formatLotto(List<Integer> lottoNumbers) {
        List<String> numbers = lottoNumbers.stream()
            .sorted()
            .map(Object::toString)
            .toList();

        String numbersWithDelimiter = String.join(DELIMITER, numbers);

        return String.format(LOTTO_MESSAGE_FORMAT, numbersWithDelimiter);
    }

    public static void printStatistic(StatisticDto dto) {

        Map<LottoRanking, Integer> winningResult = dto.winningResult();

        System.out.println(STATISTICS_TITLE_MESSAGE);

        WINNING_RANKINGS.forEach(ranking -> {
            System.out.printf(RANK_MATCH_MESSAGE_FORMAT,
                getRankConditionMessage(ranking),
                formatMoney(ranking.getPrizeValue()),
                winningResult.get(ranking));
        });

        System.out.printf(EARNING_RATE_MESSAGE_FORMAT, dto.earningRate());
    }

    private static String getRankConditionMessage(LottoRanking ranking) {
        StringBuilder stringBuilder = new StringBuilder(
            String.format(RANK_CONDITION_MESSAGE_FORMAT, ranking.getNumberOfMatches())
        );

        if (ranking == SECOND) {
            stringBuilder.append(BONUS_BALL_CONDITION_MESSAGE);
        }

        return stringBuilder.toString();
    }

    private static String formatMoney(int prize) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(prize);
    }
}
