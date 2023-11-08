package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.OutputMessage;
import lotto.constant.Ranking;
import lotto.model.Lotto;
import lotto.util.IntUtil;
import lotto.util.OutputUtil;

public class OutputView {

    public static void showLottoNumbers(List<Lotto> lottos) {
        System.out.println(lottos.size() + OutputMessage.INFORM_QUANTITY_MESSAGE.getOutputMessage());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
        printNextLine();
    }

    private static void showWinningStatics() {
        System.out.println(OutputMessage.SHOW_RESULT.getOutputMessage());
        System.out.println(OutputMessage.DIVIDING_LINE.getOutputMessage());
    }

    private static void showThreeWinning(int count) {
        System.out.print(OutputMessage.FIFTH_WIN_MESSAGE.getOutputMessage());
        System.out.println(count + "개");
    }

    private static void showFourWinning(int count) {
        System.out.print(OutputMessage.FOURTH_WIN_MESSAGE.getOutputMessage());
        System.out.println(count + "개");
    }

    private static void showFiveWinning(int count) {
        System.out.print(OutputMessage.THIRD_WIN_MESSAGE.getOutputMessage());
        System.out.println(count + "개");
    }

    private static void showFiveWithBonusWinning(int count) {
        System.out.print(OutputMessage.SECOND_WIN_MESSAGE.getOutputMessage());
        System.out.println(count + "개");
    }

    private static void showLottoWinning(int count) {
        System.out.print(OutputMessage.LOTTO_WIN_MESSAGE.getOutputMessage());
        System.out.println(count + "개");
    }

    public static void showResult(Map<Integer, Integer> winningCount, int money, long profit) {
        showWinningCount(winningCount);
        showProfitRate(money, profit);
    }

    public static void showWinningCount(Map<Integer, Integer> winningCount) {
        showWinningStatics();
        showThreeWinning(winningCount.get(Ranking.FIFTH.getRanking()));
        showFourWinning(winningCount.get(Ranking.FOURTH.getRanking()));
        showFiveWinning(winningCount.get(Ranking.THIRD.getRanking()));
        showFiveWithBonusWinning(winningCount.get(Ranking.SECOND.getRanking()));
        showLottoWinning(winningCount.get(Ranking.FIRST.getRanking()));
    }

    public static void showProfitRate(int money, long profit) {
        double rate = IntUtil.calculateProfit(profit, money);
        String formatRate = OutputUtil.makeEasyToRead(rate);
        System.out.printf("총 수익률은 %s%%입니다.%n", formatRate);
    }

    public static void printNextLine() {
        System.out.println();
    }
}
