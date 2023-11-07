package lotto;

import java.util.Collection;
import java.util.List;
import java.util.Collections;

public class PrintResult {
    RankPrize first = RankPrize.FIRST;
    RankPrize second = RankPrize.SECOND;
    RankPrize third = RankPrize.THIRD;
    RankPrize fourth = RankPrize.FOURTH;
    RankPrize fifth = RankPrize.FIFTH;
    RankPrize unrank = RankPrize.NOPRIZE;
    public PrintResult() {
    }

    protected void printMyNums(int count, List<List<Integer>> myNums) {
        System.out.println(String.format("%d개를 구매했습니다.", count));

        for(int i = 0; i < count; i++) {
            System.out.println(myNums.get(i));
        }
    }

    protected void printResult(List<Integer> rank) {
        System.out.println("\n당첨 통계\n---");

        System.out.println(String.format("3개 일치 (%s원) - %d개", fifth.getPrizeStr(), Collections.frequency(rank, fifth.getRank())));
        System.out.println(String.format("4개 일치 (%s원) - %d개", fourth.getPrizeStr(), Collections.frequency(rank, fourth.getRank())));
        System.out.println(String.format("5개 일치 (%s원) - %d개", third.getPrizeStr(), Collections.frequency(rank, third.getRank())));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (%s원) - %d개", second.getPrizeStr(), Collections.frequency(rank, second.getRank())));
        System.out.println(String.format("6개 일치 (%s원) - %d개", first.getPrizeStr(), Collections.frequency(rank, first.getRank())));

        System.out.println(String.format("총 수익률은 %.1f%%입니다.", calculateProfit(rank)));
    }

    private double calculateProfit(List<Integer> rank) {
        double profit;
        double money = 0;
        double price = rank.size() * 1000;

        for(int i = 0; i < rank.size(); i++) {
            money += (definePrize(rank.get(i)).getPrizeInt());
        }

        System.out.println(money);

        profit = (money/price) * 100;
        return profit;
    }

    private RankPrize definePrize(int rank) {
        if(rank == 1) {
            return first;
        }
        if(rank == 2) {
            return second;
        }
        if(rank == 3) {
            return third;
        }
        if(rank == 4) {
            return fourth;
        }
        if(rank == 5) {
            return fifth;
        }
        return unrank;
    }

}
