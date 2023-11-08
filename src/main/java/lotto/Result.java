package lotto;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Result {

    private Map<Ranking, Integer> result;

    public Result() {
        this.result = Arrays.stream(Ranking.values())
                .collect(Collectors.toMap(ranking -> ranking, value -> 0));
    }

    public void put(Ranking ranking) {
        result.put(ranking, result.get(ranking) + 1);
    }
}
