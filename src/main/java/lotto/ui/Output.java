package lotto.ui;

import static lotto.constant.GameMessage.MATCH_BONUS;
import static lotto.constant.GameMessage.MATCH_N_NUMBERS;
import static lotto.constant.GameMessage.N_NUMBERS;
import static lotto.constant.GameMessage.N_PERCENTS;
import static lotto.constant.GameMessage.TOTAL_REVENUE_RATE_IS;
import static lotto.constant.GameMessage.WIN_STATISTICS;
import static lotto.constant.GameMessage.YOU_BOUGHT_N_LOTTOS;

import java.util.EnumMap;
import java.util.List;
import lotto.Rank;
import lotto.domain.Lotto;
import lotto.domain.Price;

public class Output {

    public static void printBoughtAmount(Price price) {
        System.out.println(price.getAmount() + YOU_BOUGHT_N_LOTTOS.getMessage());
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printGameResult(EnumMap<Rank, Integer> result) {
        System.out.println(WIN_STATISTICS.getMessage());
        for (Rank rank : result.keySet()) {
            System.out.print(rank.getMatchCount());
            System.out.print(MATCH_N_NUMBERS.getMessage());
            if (rank.getMatchBonus() != null && rank.getMatchBonus()) {
                System.out.print(MATCH_BONUS.getMessage());
            }
            System.out.print(" (");
            System.out.print(String.format("%,d", rank.getPrizeMoney()));
            System.out.print("원) - ");
            System.out.print(result.get(rank));
            System.out.println(N_NUMBERS.getMessage());
        }
    }

    public static void printRevenueRate(double revenueRate) {
        System.out.print(TOTAL_REVENUE_RATE_IS.getMessage());
        System.out.printf("%.1f", revenueRate);
        System.out.println(N_PERCENTS.getMessage());
    }
}
