package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<List<Integer>> getLottosNumbers() {
        return lottos.stream()
            .map(Lotto::getNumbers)
            .collect(Collectors.toList());
    }
}