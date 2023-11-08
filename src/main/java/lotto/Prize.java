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

    public void calcTotalPrize(int currentPrize){
        this.totalPrize += currentPrize;
    }

    public int getTotalPrize(){
        return totalPrize;
    }

    public List<Integer> getTotalRankInfo(){
        return prizeRankSum;
    }
}
