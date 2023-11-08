package lotto.View;

import java.util.List;

public class OutputView {
    private static final String OPEN_SIGN = "[";
    private static final String CLOSE_SIGN = "]";
    private static final String COMMA_SEPARATOR = ", ";
    private static final String PRIZE_THREE_MATCH = "5,000";
    private static final String PRIZE_FOUR_MATCH = "50,000";
    private static final String PRIZE_FIVE_MATCH = "1,500,000";
    private static final String PRIZE_FIVE_MATCH_WITH_BONUS = "30,000,000";
    private static final String PRIZE_SIX_MATCH = "2,000,000,000";

    public static void returnLottoCount(int lotto) {
        System.out.println(lotto + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer> numbers) {
        System.out.print(OPEN_SIGN);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i < numbers.size() - 1) {
                System.out.print(COMMA_SEPARATOR);
            }
        }
        System.out.println(CLOSE_SIGN);
    }

    public static void printWinningStatistics(int threeMatch, int fourMatch, int fiveMatch, int fiveMatchWithBonus,
                                              int sixMatch) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (" + PRIZE_THREE_MATCH + "원) - " + threeMatch + "개");
        System.out.println("4개 일치 (" + PRIZE_FOUR_MATCH + "원) - " + fourMatch + "개");
        System.out.println("5개 일치 (" + PRIZE_FIVE_MATCH + "원) - " + fiveMatch + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + PRIZE_FIVE_MATCH_WITH_BONUS + "원) - " + fiveMatchWithBonus + "개");
        System.out.println("6개 일치 (" + PRIZE_SIX_MATCH + "원) - " + sixMatch + "개");
    }

    public static void printRateOfReturn(double rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
