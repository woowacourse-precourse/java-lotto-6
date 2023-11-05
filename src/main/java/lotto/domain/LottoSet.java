package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoSet {

    private List<Lotto> lottoSet = new ArrayList<>();
    public LottoSet(List<Lotto> lottoSet){
        this.lottoSet = lottoSet;
    }

    public List<Lotto> getLottoSet() {
        return this.lottoSet;
    }
}
