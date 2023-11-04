package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prize {
    private List<Integer> prizeRank;

    public Prize(){
        // 2nd(5+1), 1st(6), 3rd(5), 4th(4), 5th(3), empty(2), empty(1), empty(0)
        prizeRank = new ArrayList<Integer>(Arrays.asList(-1,0,0,0,0,0,0,0));
    }

    public void addPrize(int rank){
        int toChangeRank = prizeRank.get(rank);
        prizeRank.set(rank, toChangeRank + 1);
    }
}
