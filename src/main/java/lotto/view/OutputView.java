package lotto.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Rank;
import lotto.vo.Lotto;

public class OutputView {
    private static final String RESULT_LOTTO_COUNT_PRINT_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_LOTTO_PRIZE_MESSAGE = System.lineSeparator() + "당첨 통계";
    private static final String RESULT_LOTTO_PRIZE_MATCH_COUNT_MESSAGE = "%d개" + System.lineSeparator();
    private static final String RATE_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private static final String RESULT_LOTTO_NUMBERS_DELIMETER = ", ";
    private static final String RESULT_LOTTO_PRIZE_SEPERATOR = "---";

    public static void printLottoes(List<Lotto> lottoes) {
        printLottoCount(lottoes.size());
        for (Lotto lotto : lottoes) {
            printCurrentLottoList(lotto);
        }
    }

    private static void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + RESULT_LOTTO_COUNT_PRINT_MESSAGE);
    }

    private static void printCurrentLottoList(Lotto lotto) {
        String lottoNumbers = lotto.getNumbers()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(RESULT_LOTTO_NUMBERS_DELIMETER));

        System.out.println("[" + lottoNumbers + "]");
    }

    public static void printResultLottoPrize(Map<Rank, Integer> rankingConutResult) {
        System.out.println(RESULT_LOTTO_PRIZE_MESSAGE);
        System.out.println(RESULT_LOTTO_PRIZE_SEPERATOR);

        for (Rank rank : rankingConutResult.keySet()) {
            if (rank == Rank.UNRANK) {
                continue;
            }

            int count = rankingConutResult.get(rank);
            System.out.print(rank.getOutputMessage());
            System.out.printf(RESULT_LOTTO_PRIZE_MATCH_COUNT_MESSAGE, count);
        }
    }

    public static void printPrizePercentResult(BigDecimal out) {
        System.out.printf(RATE_RETURN_MESSAGE, out);
    }

}