package view;

import config.GameConfig;
import java.text.DecimalFormat;
import java.util.List;

public class OutputView {

    private final static String BEFORE_BUYING = "구입금액을 입력해 주세요.";
    private final static String AFTER_BUYING = "%d개를 구매했습니다.";
    private final static String GET_WINNING = "당첨 번호를 입력해 주세요.";
    private final static String GET_BONUS = "보너스 번호를 입력해 주세요.";
    private final static String STATISTICS = "당첨 통계";
    private final static String LINE_SEPARATOR = "---";
    private final static String RANKING_STATISTICS = "%s (%s원) - %d개";
    private final static String TOTAL_YIELD_PREFIX = "총 수익률은 %s";
    private final static String TOTAL_YIELD_SUFFIX = "입니다.";
    private final static DecimalFormat THOUSAND_SEPARATOR = new DecimalFormat("#,###");

    public void printMoney() {
        System.out.println(BEFORE_BUYING);
    }

    public void printBuying(List<String> LottoNumbers) {
        System.out.printf(AFTER_BUYING, LottoNumbers.size());
        System.out.println();
        for (String LottoNumber : LottoNumbers) {
            System.out.println(LottoNumber);
        }
        System.out.println();
    }

    public void printWinning() {
        System.out.println(GET_WINNING);
    }

    public void printBonus() {
        System.out.println(GET_BONUS);
    }

    public void printStatistics(List<Integer> winningCounts, String yield) {
        System.out.println(STATISTICS);
        System.out.println(LINE_SEPARATOR);
        for (int rank = winningCounts.size(); rank > 0; rank--) {
            int winningCount = winningCounts.get(rank - 1);
            System.out.printf(
                    RANKING_STATISTICS,
                    GameConfig.WINNING.valueOfRank(rank).getMatchAmount(),
                    THOUSAND_SEPARATOR.format(GameConfig.WINNING.valueOfRank(rank).getPrice()),
                    winningCount);
            System.out.println();
        }
        System.out.println(String.format(TOTAL_YIELD_PREFIX, yield).concat(TOTAL_YIELD_SUFFIX));
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
