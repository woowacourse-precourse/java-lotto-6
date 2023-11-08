package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<List<Integer>> numbersList) {
        List<Lotto> lottos = new ArrayList<>();

        for (List<Integer> numbers : numbersList) {
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        this.lottos = lottos;
    }

    public List<Lotto> getRandomLottos() {
        return lottos;
    }
}
