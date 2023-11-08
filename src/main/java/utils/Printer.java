package utils;

import lotto.Rank;

import java.util.HashMap;

public class Printer {

    static final String THREE_MATCH = "3개 일치 (5,000원) - ";
    static final String FOUR_MATCH = "4개 일치 (50,000원) - ";
    static final String FIVE_MATCH = "5개 일치 (1,500,000원) - ";
    static final String FIVE_BONUS_MATCH = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    static final String SIX_MATCH = "6개 일치 (2,000,000,000원) - ";
    static final String PROFIT_PERCENTAGE = "총 수익률은 ";

    public static void inputMoney() {
        System.out.println(Messages.INPUT_MONEY);
    }

    public static void buyLotto(int count) {
        System.out.println(count + Messages.BUY_LOTTO);
    }

    public static void inputWinningNumbers() {
        System.out.println(Messages.INPUT_WINNING_NUMBERS);
    }

    public static void inputBonus() {
        System.out.println(Messages.INPUT_BONUS);
    }


    public static void statisticRank(HashMap<Rank, Integer> rankAggregation,int money) {
        StringBuilder sb = new StringBuilder();
        double sum = 0;

        sb.append(THREE_MATCH);
        sb.append(rankAggregation.getOrDefault(Rank.FIFTH, 0));
        sb.append("개\n");
        sum += rankAggregation.getOrDefault(Rank.FIFTH, 0) * Rank.FIFTH.getMoney();

        sb.append(FOUR_MATCH);
        sb.append(rankAggregation.getOrDefault(Rank.FOURTH, 0));
        sb.append("개\n");
        sum += rankAggregation.getOrDefault(Rank.FOURTH, 0) * Rank.FOURTH.getMoney();

        sb.append(FIVE_MATCH);
        sb.append(rankAggregation.getOrDefault(Rank.THIRD, 0));
        sb.append("개\n");
        sum += rankAggregation.getOrDefault(Rank.THIRD, 0) * Rank.THIRD.getMoney();

        sb.append(FIVE_BONUS_MATCH);
        sb.append(rankAggregation.getOrDefault(Rank.SECOND, 0));
        sb.append("개\n");
        sum += rankAggregation.getOrDefault(Rank.SECOND, 0) * Rank.SECOND.getMoney();

        sb.append(SIX_MATCH);
        sb.append(rankAggregation.getOrDefault(Rank.FIRST, 0));
        sb.append("개\n");
        sum += rankAggregation.getOrDefault(Rank.FIRST, 0) * Rank.FIRST.getMoney();

        double profitPercentage = (sum / money) * 100.0;
        sb.append(PROFIT_PERCENTAGE).append(String.format("%.1f%%", profitPercentage)).append("입니다.");

        System.out.println(sb.toString());
    }
}
