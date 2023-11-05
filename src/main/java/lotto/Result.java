package lotto;

import java.util.HashMap;

public class Result {
    private final HashMap<Ranking, Integer> count = new HashMap<>();

    public Result() {
        init();
    }

    private void init() {
        count.put(Ranking.FIRST, 0);
        count.put(Ranking.SECOND, 0);
        count.put(Ranking.THIRD, 0);
        count.put(Ranking.FOURTH, 0);
        count.put(Ranking.FIFTH, 0);
        count.put(Ranking.NONE, 0);
    }

    public void putIt(Ranking ranking) {
        count.put(ranking, count.get(ranking) + 1);
    }
 }
