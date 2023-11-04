package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prize {
    private List<Integer> prizeRank;
    public Prize(){
        prizeRank = new ArrayList<Integer>(Arrays.asList(-1,0,0,0,0,0));
    }

    public void addPrize(int rank){
        int toChangeRank = prizeRank.get(rank);
        prizeRank.set(rank, toChangeRank + 1);
    }
}
