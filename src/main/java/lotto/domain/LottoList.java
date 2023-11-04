package lotto.domain;

import java.util.List;

public class LottoList {
    List<Lotto> lottos;

    public LottoList(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
