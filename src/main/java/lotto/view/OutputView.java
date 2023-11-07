package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PRINT_LOTTO_AMOUNT_SENTENCE = "%d개를 구매했습니다.";
    private static final String PRINT_RESULT_START_SENTENCE = "당첨 통계";
    private static final String DEFAULT_WINNING_SENTENCE = "%d개 일치 (%s원) - %d개";
    private static final String BONUS_WINNING_SENTENCE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RETURN_RATE_SENTENCE = "총 수익률은 %s%%입니다.";
    private static final String EMPTY_LINE = "";
    private static final String DASHS = "---";

    public static void printLottos(Lottos lottos) {
        System.out.println(EMPTY_LINE);
        printLottosAmount(lottos.getLottosAmount());
        printLottosNumber(lottos.getLottosAllSortedNumber());

    }

    private static void printLottosAmount(int amount) {
        System.out.println(String.format(PRINT_LOTTO_AMOUNT_SENTENCE, amount));
    }

    private static void printLottosNumber(List<String> lottos) {
        lottos.stream()
                .forEach(lotto -> System.out.println(lotto));
        System.out.println(EMPTY_LINE);
    }

    public static void printWinningResult(LottoResult result) {
        System.out.println(EMPTY_LINE);
        System.out.println(PRINT_RESULT_START_SENTENCE);
        System.out.println(DASHS);

        printRankCount(result);
    }

    private static void printRankCount(LottoResult result) {
        result.getSortedLottoResult().stream()
                .forEach(entry -> System.out.println(makeLottoResultSentence(entry)));
    }

    private static String makeLottoResultSentence(Map.Entry<LottoRank, Integer> entry) {
        LottoRank rank = entry.getKey();

        if (rank.isBonusBall()) {
            return String.format(BONUS_WINNING_SENTENCE,
                    rank.getMatchCount(),
                    rank.getFormattedReward(),
                    entry.getValue());
        }
        return String.format(DEFAULT_WINNING_SENTENCE,
                rank.getMatchCount(),
                rank.getFormattedReward(),
                entry.getValue());
    }

    public static void printReturnRate(String result) {
        System.out.println(String.format(RETURN_RATE_SENTENCE, result));
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
