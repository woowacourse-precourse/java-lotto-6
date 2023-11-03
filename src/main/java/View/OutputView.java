package View;

import java.util.List;
import Config.GameConfig;

public class OutputView {
    private final static String BEFORE_BUYING = "구입금액을 입력해 주세요.";
    private final static String AFTER_BUYING = "%d개를 구매했습니다.";
    private final static String GET_BONUS = "당첨 번호를 입력해 주세요.";
    private final static String STATISTICS = "당첨 통계";
    private final static String LINE_SEPARATOR = "---";
    private final static String RANKING_STATISTICS = "%s (%d원) - %d개";
    private final static String TOTAL_YIELD = "총 수익률은 %s%%입니다.";

    public void printMoney(){
        System.out.println(BEFORE_BUYING);
    }

    public void printBuying(){
        System.out.println(AFTER_BUYING);
    }

    public void printBonus(){
        System.out.println(GET_BONUS);
    }

    public void printStatistics(List<Integer> winningCounts, String yield){
        System.out.println(STATISTICS);
        System.out.println(LINE_SEPARATOR);
        for (int winningCount : winningCounts){
            int rank = winningCounts.indexOf(winningCount);
            System.out.printf(RANKING_STATISTICS,
                    GameConfig.WINNING.valueOfRank(rank).getMatchAmount(),
                    GameConfig.WINNING.valueOfRank(rank).getPrice(),
                    winningCount);
            System.out.println();
        }
        System.out.printf(TOTAL_YIELD, yield);
        System.out.println();
    }
}
