package lotto.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLotto() {
        return lottos;
    }

    public List<Integer> calculateScore(Lotto answer) {
        return lottos.stream()
                .map(lotto -> lotto.calculateScore(answer))
                .collect(Collectors.toList());
    }

    public List<Integer> sortScore(Lotto answer) {
        Map<Enum, Integer> scores = new HashMap<>();
        int i = 0;
        for (int score: calculateScore(answer)) {
            scores.put(Price.get, score);
        }
    }
}
