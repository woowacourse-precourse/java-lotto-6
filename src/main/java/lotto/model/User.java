package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final List<Lotto> lotto;

    public User(List<Lotto> lotto) {
        this.lotto = lotto;
    }

    public Map<Ranking, Integer> confirmResult(wonTheLotto wonTheLotto) {
        Map<Ranking, Integer> result = initResult();
        lotto.stream()
                .map(wonTheLotto::compare)
                .forEach(ranking -> result.put(ranking, result.getOrDefault(ranking, 0) + 1));
        return result;
    }


    private Map<Ranking, Integer> initResult() {
        Map<Ranking, Integer> result = new HashMap<>();
        Arrays.stream(Ranking.values())
                .forEach(ranking -> result.put(ranking, 0));
        return result;
    }
}
