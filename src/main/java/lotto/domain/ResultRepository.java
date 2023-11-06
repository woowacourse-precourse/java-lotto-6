package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class ResultRepository {

    private Map<Rank,Integer> board=new EnumMap<>(Rank.class);

    public ResultRepository(){
        board.put(Rank.FIRST,0);
        board.put(Rank.SECOND,0);
        board.put(Rank.THIRD,0);
        board.put(Rank.FOURTH,0);
        board.put(Rank.FIFTH,0);
    }

    public void save(Rank rank){
        board.put(rank,board.get(rank)+1);
    }
}
