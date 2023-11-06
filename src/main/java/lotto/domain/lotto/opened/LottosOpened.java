package lotto.domain.lotto.opened;

import java.util.List;

public final class LottosOpened {

    private final List<LottoOpened> lottos;

    public LottosOpened(final List<LottoOpened> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public List<LottoOpened> getLottos() {
        return lottos;
    }
}
