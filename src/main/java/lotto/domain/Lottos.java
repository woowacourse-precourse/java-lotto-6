package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public final class Lottos {

    private List<Lotto> lottos;

    void addLotto(List<Integer> lotto) {
        lottos.add(new Lotto(lotto));
    }

    List<List<Integer>> getLottos() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }
}
