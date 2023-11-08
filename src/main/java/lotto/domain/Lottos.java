package lotto.domain;

import java.util.List;

public class Lottos {
    public final List<Lotto> lottoBundle;

    public Lottos(List<Lotto> lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public List<Lotto> getLottoBundle() {
        return lottoBundle;
    }

    public int numberOfLotto() {
        return lottoBundle.size();
    }
}
