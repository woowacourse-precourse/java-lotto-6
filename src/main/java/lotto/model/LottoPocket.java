package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoRanking;

public class LottoPocket {
    private List<Lotto> lottos;
    private List<LottoRanking> rankings = new ArrayList<>();

    public LottoPocket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
