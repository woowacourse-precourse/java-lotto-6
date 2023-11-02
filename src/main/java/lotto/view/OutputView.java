package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoRanking;
import lotto.dto.LottoResult;
import lotto.model.LottoNumber;

public class OutputView {

    private static final String LOTTO_NUMBERS_SIZE_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_NUMBERS_MESSAGE = "[%d, %d, %d, %d, %d, %d]";
    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계";
    private static final String LINE = "---";
    private static final String WINNING_COUNT_MESSAGE = "%s - %d개";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f입니다.";

    public static void printLottoNumbers(List<LottoNumber> lottoNumbers) {
        System.out.printf(LOTTO_NUMBERS_SIZE_MESSAGE, lottoNumbers.size());
        System.out.println();
        for (LottoNumber lottoNumber : lottoNumbers) {
            List<Integer> numbers = lottoNumber.getNumbers();
            System.out.printf(
                    LOTTO_NUMBERS_MESSAGE,
                    numbers.get(0),
                    numbers.get(1),
                    numbers.get(2),
                    numbers.get(3),
                    numbers.get(4),
                    numbers.get(5)
            );
            System.out.println();
        }
        System.out.println();
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println(LOTTO_RESULT_MESSAGE);
        System.out.println(LINE);
        printWinningCounts(lottoResult.getWinningCounts());
        printProfitRate(lottoResult.getProfitRate());
    }

    private static void printWinningCounts(Map<LottoRanking, Integer> winningCounts) {
        for (LottoRanking lottoRanking : winningCounts.keySet()) {
            System.out.printf(
                    WINNING_COUNT_MESSAGE,
                    lottoRanking.getWinningCondition(),
                    winningCounts.get(lottoRanking)
            );
            System.out.println();
        }
    }

    private static void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
