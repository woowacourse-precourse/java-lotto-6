package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;

public class Lottos {
    List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getSize() {
        return lottos.size();
    }
}
