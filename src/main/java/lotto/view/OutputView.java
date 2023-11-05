package lotto.view;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import lotto.domain.Budget;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningRank;
import lotto.domain.WinningStatistics;

public class OutputView {
    private static final String COUNT_OF_USER_LOTTOS_MESSAGE = "\n%d개를 구매했습니다.";

    public static void printUserLottos(Lottos lottos, Budget budget) {
        printCountOfUserLottos(budget);
        printLottoNumbers(lottos);
    }

    private static void printLottoNumbers(Lottos lottos){
        for(Lotto lotto : lottos.getLottos()){
            printEachLottoNumbers(lotto);
        }
    }

    private static void printEachLottoNumbers(Lotto lotto){
        System.out.println("[" + lotto.toString() + "]");
    }

    private static void printCountOfUserLottos(Budget budget){
        System.out.println(String.format(COUNT_OF_USER_LOTTOS_MESSAGE, budget.getCountOfLottoLines()));
    }

    public static void printWinningStaticstics(WinningStatistics winningStatistics){
        printWinningStatisticsHeader();
        for(int i=1; i < WinningRank.values().length; i++){
            WinningRank winningRank = WinningRank.values()[i];
            printWinningPrize(winningRank, winningStatistics.getWinningStatistics().get(winningRank));
        }
        printRevenueRate(winningStatistics.getRevenueRate());
    }

    private static void printWinningStatisticsHeader(){
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    private static void printWinningPrize(WinningRank winningRank, int countOfPrize) {
        System.out.println(winningRank.getMessage() + "(" + winningRank.getPrize() + ") - " + countOfPrize + "개");
    }

    private static void printRevenueRate(BigDecimal revenueRate){
        System.out.println(String.format("총 수익률은 %s%%입니다.%n", revenueRate.toString()));
    }
}
