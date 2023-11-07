package lotto;

import java.util.List;

public class Pocket {
    private final List<List<Integer>> lottos;

    public Pocket(List<List<Integer>> lottos) {
        this.lottos = lottos;
    }

    public List<List<Integer>> getLottos() {
        return this.lottos;
    }
}
