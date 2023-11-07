package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class ResultRepository {

    private static Map<Rank, Integer> board = new EnumMap<>(Rank.class);

    public void init() {
        Arrays.stream(Rank.values())
                .forEach(rank -> board.put(rank, 0));
    }

    public void save(Rank rank) {
        board.put(rank, board.get(rank) + 1);
    }

    public Integer findWinningByRank(Rank rank) {
        return board.get(rank);
    }

    public Map<Rank,Integer> getBoard(){
        return board;
    }

}
