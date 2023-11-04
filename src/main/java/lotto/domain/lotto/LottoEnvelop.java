package lotto.domain.lotto;

import lotto.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoEnvelop {
    private List<Lotto> lottoEnvelops;

    public LottoEnvelop() {
        lottoEnvelops = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottoEnvelops.add(lotto);
    }

    public LottoEnvelop get() {
        return (LottoEnvelop) lottoEnvelops;
    }
}
