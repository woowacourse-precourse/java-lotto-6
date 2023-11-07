package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Map;
import java.util.StringJoiner;

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

    public Map<Rank, Integer> getBoard() {
        return board;
    }

    @Override
    public String toString() {
        StringJoiner lottos = new StringJoiner("\n");
        board.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(Rank.OUT))
                .sorted(Comparator.comparingInt(n -> n.getKey().getReward()))
                .forEach(entry -> lottos.add(entry.getKey() + "-" + entry.getValue() + "개"));
        return lottos.toString();
    }

}
