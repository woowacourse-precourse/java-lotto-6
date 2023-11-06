package lotto.ui;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoRank;
import lotto.domain.Score;

public class Output {
    private static final String PURCHASE_COUNT_COMMAND = "개를 구매했습니다.";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String COMMA_DELIMITER = ", ";
    private static final String NEXT_LINE = "\n";
    private static final String LOTTO_RESULT_STATUS = "당첨 통계";
    private static final String LOTTO_RESULT_LINE = "---";
    private static final String LOTTO_RESULT_FIFTH_PRIZE = "3개 일치 (5,000원) - %d개";
    private static final String LOTTO_RESULT_FOURTH_PRIZE = "4개 일치 (50,000원) - %d개";
    private static final String LOTTO_RESULT_THIRD_PRIZE = "5개 일치 (1,500,000원) - %d개";
    private static final String LOTTO_RESULT_SECOND_PRIZE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String LOTTO_RESULT_FIRST_PRIZE = "6개 일치 (2,000,000,000원) - %d개";
    private static final int DEFAULT_SCORE = 0;

    public static void printPurchaseCount(int count) {
        System.out.println(NEXT_LINE + count + PURCHASE_COUNT_COMMAND);
    }

    public static void printLottoBundle(LottoBundle lottoBundle) {
        for (Lotto lotto : lottoBundle.getLottoBundle()) {
            printSingleLotto(lotto);
        }
        System.out.println();
    }

    private static void printSingleLotto(Lotto lotto) {
        final List<String> singleLottoBought = lotto.getLotto()
                .stream()
                .map(String::valueOf)
                .toList();

        System.out.println(OPEN_BRACKET + String.join(COMMA_DELIMITER, singleLottoBought) + CLOSE_BRACKET);
    }

    public static void printLottoResult(Score score) {
        System.out.println();
        System.out.println(LOTTO_RESULT_STATUS);
        System.out.println(LOTTO_RESULT_LINE);
        printLottoRankResult(score.getLottoResult());
    }

    private static void printLottoRankResult(Map<LottoRank, Integer> lottoRank) {
        System.out.println(
                String.format(LOTTO_RESULT_FIFTH_PRIZE, lottoRank.getOrDefault(LottoRank.FIFTH_PRIZE, DEFAULT_SCORE)));
        System.out.println(String.format(LOTTO_RESULT_FOURTH_PRIZE,
                lottoRank.getOrDefault(LottoRank.FOURTH_PRIZE, DEFAULT_SCORE)));
        System.out.println(
                String.format(LOTTO_RESULT_THIRD_PRIZE, lottoRank.getOrDefault(LottoRank.THIRD_PRIZE, DEFAULT_SCORE)));
        System.out.println(String.format(LOTTO_RESULT_SECOND_PRIZE,
                lottoRank.getOrDefault(LottoRank.SECOND_PRIZE, DEFAULT_SCORE)));
        System.out.println(
                String.format(LOTTO_RESULT_FIRST_PRIZE, lottoRank.getOrDefault(LottoRank.FIRST_PRIZE, DEFAULT_SCORE)));
    }

}
