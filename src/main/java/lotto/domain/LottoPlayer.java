package lotto.domain;

import java.util.List;

public class LottoPlayer {

    private List<Lotto> lottos;

    public LottoPlayer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
