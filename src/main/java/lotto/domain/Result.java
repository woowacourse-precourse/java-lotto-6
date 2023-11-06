package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<Integer> ranks;
    static final int RANK_NUMBER = 6;
    public Result(){
        ranks = new ArrayList<Integer>();
        for(int i=0; i<RANK_NUMBER; i++){
            ranks.add(0);
        }
    }

    public void countRank(int rank){
        ranks.set(rank-1, ranks.get(rank-1)+1);
    }


    public List<Integer> getRanks(){
        return ranks;
    }
}
