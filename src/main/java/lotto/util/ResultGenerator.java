package lotto.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

public class ResultGenerator {
    public Map<Rank, Integer> createLottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Rank, Integer> result = initResult();
        lottos.stream()
                .map(winningLotto::matchingNumbers)
                .forEach(rank -> result.put(rank, result.get(rank) + 1));
        return result;
    }

    private Map<Rank, Integer> initResult() {
        Map<Rank, Integer> result = new HashMap<>();
        Arrays.stream(Rank.values())
                .forEach(rank -> result.put(rank, 0));
        return result;
    }
}
