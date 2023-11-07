package lotto.view;

import lotto.Lotto;

import java.util.List;

import lotto.domain.Rank;
import lotto.domain.RankContainer;
import main.java.lotto.domain.WinningLottos;
public class SystemOutput {

    private static final String AMOUNT_OF_PURCHASE = "%d개를 구매했습니다.";
    private static final String NEWLINE = "%n";
    private static final String WINNING_STATISTIC = "당첨 통계";
    private static final String NEWLINE_TWO = "\n";
    private static final String LINE_SEPERATOR = "---";
    private static final String TOTAL_RETURN = "총 수익률은 %.1f%%입니다.";
    private static final String CORRESPOND_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String CORRESPOND = "%d개 일치 (%s원) - %d개";
    private static final String COMMA_DECIMAL = "%,d";
    public static void printPurchaseAmount(int purchaseAmount) {
        System.out.printf((AMOUNT_OF_PURCHASE) + NEWLINE, (purchaseAmount / 1000));
    }

    public static void printWiningLotto(WinningLottos winningLottos) {
        List<Lotto> winningLottoGroup = winningLottos.getWiningLottos();
        for (Lotto lotto : winningLottoGroup) {
            System.out.println(lotto);
        }
    }

    public static void printRankResult(RankContainer rankContainer, double rate) {
        System.out.println(WINNING_STATISTIC + NEWLINE_TWO + LINE_SEPERATOR);
        for (Rank rank : Rank.values()) {
            if (!rank.equals(Rank.NONE)) {
                System.out.println(getRankContainerResult(rank, rankContainer));
            }
        }
        System.out.printf((TOTAL_RETURN) + NEWLINE_TWO, rate);
    }

    public static String getRankContainerResult(Rank rank, RankContainer rankContainer) {
        if (rank == Rank.SECOND) {
            return String.format(CORRESPOND_BONUS, rank.getCount(), String.format(COMMA_DECIMAL, rank.getAward()), rankContainer.getRankContainer(rank));
        }

        return String.format(CORRESPOND, rank.getCount(), String.format(COMMA_DECIMAL, rank.getAward()), rankContainer.getRankContainer(rank));
    }




}
