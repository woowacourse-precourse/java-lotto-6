package view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.WinningRanking;

public class Output {

    private static final String OUTPUT_LOTTO_QUANTITY = "개를 구매했습니다.";
    private static final String OUTPUT_LOTTO_SAME = "개 일치";
    private static final String OUTPUT_BONUS_BALL = ", 보너스 볼 일치";
    private static final String OUTPUT_OPEN_PARENTHESIS = " (";
    private static final String OUTPUT_CLOSE_PARENTHESIS = "원) - ";
    private static final String OUTPUT_COUNT = "개\n";
    private static final String OUTPUT_WINNING_STATISTICS = """
            당첨 통계
            ---
            """;

    public static void printIssuedLotto(List<Lotto> lotteries) {
        System.out.println("\n" + lotteries.size() + OUTPUT_LOTTO_QUANTITY);
        lotteries.forEach(System.out::println);
    }

    public static void printWinningStatistics(Map<WinningRanking, Integer> winningStatistics) {
        StringBuilder sb = new StringBuilder("\n" + OUTPUT_WINNING_STATISTICS);
        for (WinningRanking winningRanking : WinningRanking.values()) {
            sb.append(winningRanking.getCountOfMatch()).append(OUTPUT_LOTTO_SAME);
            if (winningRanking == WinningRanking.SECOND) {
                sb.append(OUTPUT_BONUS_BALL);
            }
            sb.append(OUTPUT_OPEN_PARENTHESIS);
            sb.append(NumberFormat.getInstance().format(winningRanking.getWinningAmount()));
            sb.append(OUTPUT_CLOSE_PARENTHESIS);
            sb.append(winningStatistics.get(winningRanking));
            sb.append(OUTPUT_COUNT);
        }
        System.out.print(sb);
    }
}
