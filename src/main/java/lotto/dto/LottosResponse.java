package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;

public class LottosResponse {
    private List<Lotto> lottos;

    public LottosResponse(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
