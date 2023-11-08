package lotto.vo;

import java.util.List;
import lotto.domain.Lotto;

public class Wallet {

    private final List<Lotto> lottoBundle;

    public Wallet(List<Lotto> lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public List<Lotto> getLottoBundle() {
        return lottoBundle;
    }
}
