package lotto.domain;

import java.util.List;

final class Lottos {

    private List<Lotto> lottos;

    void addLotto(List<Integer> lotto) {
        lottos.add(new Lotto(lotto));
    }
}
