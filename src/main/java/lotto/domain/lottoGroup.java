package lotto.domain;

import java.util.List;

public class lottoGroup {
    private List<Lotto> lottoGroup;

    public lottoGroup(List<Lotto> lottoGroup) {
        this.lottoGroup = lottoGroup;
    }

    public List<Lotto> getLottoGroup() {
        return lottoGroup;
    }
}
