package lotto.View;

import lotto.Domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printLottosSize(int size) {
        System.out.println(String.format("%d개를 구매했습니다.", size));
    }

    public static void printLottosNumbers(List<String> lottos) {
        for (String lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printRankCount(Map<Rank,Integer> rankCount) {
        System.out.println(Rank.FIFTH.getMatchedNumbers()+"개 일치 (5,000원) - "+rankCount.getOrDefault(Rank.FIFTH,0)+"개");
        System.out.println(Rank.FOURTH.getMatchedNumbers()+"개 일치 (50,000원) - "+rankCount.getOrDefault(Rank.FOURTH,0)+"개");
        System.out.println(Rank.THIRD.getMatchedNumbers()+"개 일치 (1,500,000원) - "+rankCount.getOrDefault(Rank.THIRD,0)+"개");
        System.out.println(Rank.SECOND.getMatchedNumbers()+"개 일치, 보너스 볼 일치 (30,000,000원) - "+rankCount.getOrDefault(Rank.SECOND,0)+"개");
        System.out.println(Rank.FIRST.getMatchedNumbers()+"개 일치 (2,000,000,000원) - "+rankCount.getOrDefault(Rank.FIRST,0)+"개");
    }

    public static void printReturnRate(double returnRate) {
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }
}
