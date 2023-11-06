package lotto.model;

import lotto.domain.Lotto;

import java.util.List;

public class LottoNumberModel {
    private List<Lotto> lotto;

    public LottoNumberModel(List<Lotto> lotto) {
        this.lotto = lotto;
    }

    public List<Lotto> getLotto() {
        return lotto;
    }


}
