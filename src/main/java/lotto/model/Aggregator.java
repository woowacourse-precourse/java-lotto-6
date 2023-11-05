package lotto.model;

import java.util.List;

public class Aggregator {

    public List<Integer> result(List<Lotto> lottos, List<Integer> winningNumbers) {
        return lottos.stream()
                .map(lotto -> (int) lotto.getNumbers()
                        .stream()
                        .filter(winningNumbers::contains)
                        .count())
                .toList();
    }
}
