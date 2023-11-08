package utils;

import lotto.Lotto;
import lotto.Rank;

import java.util.HashMap;

public class Printer {

    public static void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void buyLotto(int count){
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void inputBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void statisticRank(HashMap<Rank, Integer> rankAggregation,int money) {
        StringBuilder sb = new StringBuilder();
        double sum = 0;

        sb.append("3개 일치 (5,000원) - ");
        sb.append(rankAggregation.getOrDefault(Rank.FIFTH,0));
        sb.append("개\n");
        sum += rankAggregation.getOrDefault(Rank.FIFTH, 0) * Rank.FIFTH.getMoney();

        sb.append("4개 일치 (50,000원) - ");
        sb.append(rankAggregation.getOrDefault(Rank.FOURTH,0));
        sb.append("개\n");
        sum += rankAggregation.getOrDefault(Rank.FOURTH, 0) * Rank.FOURTH.getMoney();

        sb.append("5개 일치 (1,500,000원) - ");
        sb.append(rankAggregation.getOrDefault(Rank.THIRD,0));
        sb.append("개\n");
        sum += rankAggregation.getOrDefault(Rank.THIRD, 0) * Rank.THIRD.getMoney();

        sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        sb.append(rankAggregation.getOrDefault(Rank.SECOND,0));
        sb.append("개\n");
        sum += rankAggregation.getOrDefault(Rank.SECOND, 0) * Rank.SECOND.getMoney();

        sb.append("6개 일치 (2,000,000,000원) - ");
        sb.append(rankAggregation.getOrDefault(Rank.FIRST,0));
        sb.append("개\n");
        sum += rankAggregation.getOrDefault(Rank.FIRST, 0) * Rank.FIRST.getMoney();

        double profitPercentage = (sum / money) * 100.0;
        sb.append("총 수익률은 ").append(String.format("%.1f%%", profitPercentage)).append("입니다.");

        System.out.println(sb.toString());
    }
}
