package lotto;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private final Map<Score, Integer> result;

    public Result() {
        result = new HashMap<>();
        for (Score score : Score.values()) {
            result.put(score, 0);
        }
    }

    public void count(Score score) {
        result.compute(score, (s, i) -> {
            if (i != null) {
                return i + 1;
            }
            return 0;
        });
    }

    public int getCount(Score score) {
        return result.get(score);
    }

}
