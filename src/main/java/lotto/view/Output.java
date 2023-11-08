package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;

public class Output {
    private static final String MSG_ASK_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MSG_PUBLISHED_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String MSG_ASK_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String MSG_ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String MSG_WINNER_STATISTICS_INTRODUCTION = "당첨 통계";
    private static final String MSG_WINNER_STATISTICS_5TH = "3개 일치 (5,000원)";
    private static final String MSG_WINNER_STATISTICS_4TH = "4개 일치 (50,000원)";
    private static final String MSG_WINNER_STATISTICS_3RD = "5개 일치 (1,500,000원)";
    private static final String MSG_WINNER_STATISTICS_2ND = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    private static final String MSG_WINNER_STATISTICS_1ST = "6개 일치 (2,000,000,000원)";
    private static final String MSG_TOTAL_RETURN_HEAD = "총 수익률은 ";
    private static final String MSG_TOTAL_RETURN_FOOT = "입니다.";
    private static final String MSG_ERROR_INSTRUCTION = "[ERROR]";
    private static final String COUNT = "개";
    private static final String DASH = "-";
    private static final String BLANK = " ";
    private static final String COMMA = ",";
    private static final String NEW_LINE = "\n";
    private static final String PERCENTAGE = "%";
    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";

    public static void askAmount() {
        System.out.println(MSG_ASK_AMOUNT);
    }

    public static void printPublishedLottoInformation(List<Lotto> lottoes) {
        String message = NEW_LINE + lottoes.size() + MSG_PUBLISHED_LOTTO_COUNT + NEW_LINE;
        for (int i = 0; i < lottoes.size(); i++) {
            message += LEFT_BRACKET;
            List<Integer> numbers = lottoes.get(i).getNumbers();
            for (int j = 0; j < numbers.size() - 1; j++) {
                message += numbers.get(j) + COMMA + BLANK;
            }
            message += numbers.get(numbers.size() - 1) + RIGHT_BRACKET + NEW_LINE;
        }
        System.out.print(message);
    }

    public static void askWinningNumber() {
        System.out.println(NEW_LINE + MSG_ASK_WINNING_NUMBER);
    }

    public static void askBonusNumber() {
        System.out.println(NEW_LINE + MSG_ASK_BONUS_NUMBER);
    }

    public static void printWinningStatistics(WinningResult winningResult) {
        String message = NEW_LINE + MSG_WINNER_STATISTICS_INTRODUCTION + NEW_LINE
                + DASH + DASH + DASH + NEW_LINE
                + MSG_WINNER_STATISTICS_5TH + BLANK + DASH + BLANK + winningResult.getNumberOfFifth() + COUNT + NEW_LINE
                + MSG_WINNER_STATISTICS_4TH + BLANK + DASH + BLANK + winningResult.getNumberOfFourth() + COUNT
                + NEW_LINE
                + MSG_WINNER_STATISTICS_3RD + BLANK + DASH + BLANK + winningResult.getNumberOfThird() + COUNT + NEW_LINE
                + MSG_WINNER_STATISTICS_2ND + BLANK + DASH + BLANK + winningResult.getNumberOfSecond() + COUNT
                + NEW_LINE
                + MSG_WINNER_STATISTICS_1ST + BLANK + DASH + BLANK + winningResult.getNumberOfFirst() + COUNT;

        System.out.println(message);
    }

    public static void printTotalReturn(double totalReturn) {
        String message = MSG_TOTAL_RETURN_HEAD + totalReturn + PERCENTAGE + MSG_TOTAL_RETURN_FOOT;
        System.out.println(message);
    }

    public static void printErrorMessage(String message) {
        System.out.println(MSG_ERROR_INSTRUCTION + BLANK + message);
    }
}
