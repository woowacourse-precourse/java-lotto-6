package lotto.model;

import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public int getCount() {
        return this.lottos.size();
    }

    public List<List<Integer>> getHistory() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .toList();
    }
}
