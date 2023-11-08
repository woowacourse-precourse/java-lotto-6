package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prize {
    private List<Integer> prizeRankSum;
    private int totalPrize;

    public Prize(){
        // 2nd(5+1), 1st(6), 3rd(5), 4th(4), 5th(3), empty(2), empty(1), empty(0)
        prizeRankSum = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0));
        totalPrize = 0;
    }

    public void addPrize(int rank){
        int toChangeRank = prizeRankSum.get(rank);
        prizeRankSum.set(rank, toChangeRank + 1);
    }

    public List<Integer> getTotalRankInfo(){
        return prizeRankSum;
    }

    public void calcTotalPrizeRate(int startPayment){
        double totalPrizeRate;
        totalPrizeRate = this.totalPrize * 1.0 / startPayment * 1.0 * 100;
        System.out.println("총 수익률은 " + totalPrizeRate + "%입니다.");
    }

    public void calcTotalPrize(int currentPrize){
        this.totalPrize += currentPrize;
    }
}
