package lotto.view;

import java.util.List;

public class Output {
    private static final String MSG_ASK_AMOUNT = "구입금액을 입력해 주세요.";
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
    private static final String COUNT = "개";
    private static final String DASH = "-";
    private static final String BLANK = " ";
    private static final String NEW_LINE = "\n";
    private static final String PERCENTAGE = "%";

    public static void askAmount() {
        System.out.println(MSG_ASK_AMOUNT);
    }

    public static void askWinningNumber() {
        System.out.println(MSG_ASK_WINNING_NUMBER);
    }

    public static void askBonusNumber() {
        System.out.println(MSG_ASK_BONUS_NUMBER);
    }

    public static void printWinningStatistics(List<Integer> winningStatistics){
        String message = MSG_WINNER_STATISTICS_INTRODUCTION + NEW_LINE
                + DASH + DASH + DASH + NEW_LINE
                + MSG_WINNER_STATISTICS_5TH + BLANK + DASH + BLANK + winningStatistics.get(4) + COUNT + NEW_LINE
                + MSG_WINNER_STATISTICS_4TH + BLANK + DASH + BLANK + winningStatistics.get(3)+ COUNT + NEW_LINE
                + MSG_WINNER_STATISTICS_3RD + BLANK + DASH + BLANK + winningStatistics.get(2)+ COUNT + NEW_LINE
                + MSG_WINNER_STATISTICS_2ND + BLANK + DASH + BLANK + winningStatistics.get(1)+ COUNT + NEW_LINE
                + MSG_WINNER_STATISTICS_1ST + BLANK + DASH + BLANK + winningStatistics.get(0)+ COUNT;

        System.out.println(message);
    }

    public static void printTotalReturn(double totalReturn){
        String message = MSG_TOTAL_RETURN_HEAD+ totalReturn +PERCENTAGE+ BLANK + MSG_TOTAL_RETURN_FOOT;
        System.out.println(message);
    }
}
