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
}
