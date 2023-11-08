package lotto.model.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.Lotto;

public class LottoWallet {
    private final List<Lotto> lottos;

    public LottoWallet(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
