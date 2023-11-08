package lotto.results.domain;

import static lotto.component.rank.Rank.getReward;
import static lotto.component.rank.Statistics.getStatistics;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Statistics {

    private final List<Integer> counts;

    private Long totalReward;

    public Statistics() {
        totalReward = 0L;
        counts = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            counts.add(0);
        }
    }

    public void incrementCount(Integer rank) {
        counts.set(rank, counts.get(rank) + 1);
        totalReward += getReward(rank);
    }

    public void printStatistics() {
        System.out.println("당첨 통계\n" + "---");
        for (int i = 5; i > 0; i--) {
            System.out.println(getStatistics(i) + " - " + counts.get(i) + "개");
        }
    }

    public void printReturnRate(Integer spendMoney) {
        DecimalFormat decFormat = new DecimalFormat("###,##0.0");

        String str = decFormat.format(calculateReturnRate(spendMoney));
        System.out.println("총 수익률은 " + str + "%입니다.");
    }

    private Double calculateReturnRate(Integer spendMoney) {
        return (totalReward / (double) spendMoney) * 100;
    }

}
