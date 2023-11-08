package lotto.view;

import static lotto.util.ConstantUtils.*;

import java.util.StringJoiner;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPrize;
import lotto.dto.LottoStatisticResponse;
import lotto.dto.LottosResponse;

public class OutputView {

    private static final String LOTTO_PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.\n";
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_NUMBERS_PROMPT = "\n당첨 번호를 입력해 주세요.\n";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.\n";
    private static final String WINNING_STATISTICS_HEADER = "\n당첨 통계\n";
    private static final String DIVIDER = "---\n";
    private static final String WINNING_STATISTICS_FORMAT = "%s개 일치 (%s원) - %d개\n";
    private static final String WINNING_WITH_BONUS_STATISTIC_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String TOTAL_EARNING_RATE_FORMAT = "총 수익률은 %.1f%%입니다.\n";
    private static final String STRING_JOIN_PREFIX = "[";
    private static final String STRING_JOIN_SUFFIX = "]";
    private static final String ERROR_MESSAGE = "[ERROR]";


    public static void printLottoPurchaseAmountPrompt() {
        System.out.print(LOTTO_PURCHASE_AMOUNT_PROMPT);
    }

    public static void printLottoCount(int lottoCount) {
        System.out.printf(LOTTO_COUNT_MESSAGE, lottoCount);
    }

    public static void printWinningNumbersPrompt() {
        System.out.print(WINNING_NUMBERS_PROMPT);
    }

    public static void printBonusNumberPrompt() {
        System.out.print(BONUS_NUMBER_PROMPT);
    }

    public static void printLottos(LottosResponse lottosResponse) {
        for (Lotto lotto : lottosResponse.getLottos().asList()) {
            StringJoiner stringJoiner = new StringJoiner(DELIMITER + SPACE, STRING_JOIN_PREFIX,
                STRING_JOIN_SUFFIX);
            lotto.getNumbers().forEach(
                number -> stringJoiner.add(String.valueOf(number))
            );
            printLotto(stringJoiner.toString());
        }
    }

    public static void printLotto(String lotto) {
        System.out.print(lotto + "\n");
    }

    public static void printError(String errorMessage) {
        System.out.print(ERROR_MESSAGE + errorMessage + "\n");
    }

    public static void printLottoStatistic(LottoStatisticResponse response) {
        System.out.print(WINNING_STATISTICS_HEADER);
        System.out.print(DIVIDER);
        for (LottoPrize prize : LottoPrize.values()) {
            if (prize == LottoPrize.LOSE) {
                continue;
            }
            if (prize == LottoPrize.SECOND) {
                int count = response.getWinningCount().getOrDefault(prize, 0);
                System.out.printf(WINNING_WITH_BONUS_STATISTIC_FORMAT, prize.matchCount() + 1,
                    formatPrizeMoney(
                        prize.prizeAmount()), count);
                continue;
            }
            int count = response.getWinningCount().getOrDefault(prize, 0);
            System.out.printf(WINNING_STATISTICS_FORMAT, prize.matchCount(),
                formatPrizeMoney(prize.prizeAmount()), count);
        }
        System.out.printf(TOTAL_EARNING_RATE_FORMAT, response.getEarningRate());
    }

    private static String formatPrizeMoney(long prizeMoney) {
        return String.format("%,d", prizeMoney);
    }
}
