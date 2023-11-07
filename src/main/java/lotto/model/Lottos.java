package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public HashMap<Rank, Integer> calculateResult(WinnerLotto winnerLotto) {
        HashMap<Rank, Integer> result = initResult();
        lottos.stream().map(winnerLotto::compare)
                .forEach(rank -> result.put(rank, result.getOrDefault(rank, 0) + 1));

        return result;
    }

    private HashMap<Rank, Integer> initResult() {
        HashMap<Rank, Integer> result = new HashMap<>();
        Arrays.stream(Rank.values())
                .forEach(rank -> result.put(rank, 0));
        return result;
    }

}
