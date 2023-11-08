package lotto.dto;

import lotto.domain.lotto.Lottos;

public class LottosResponse {

    private final Lottos lottos;

    private LottosResponse(Lottos lottos) {
        this.lottos = lottos;
    }

    public static LottosResponse from(Lottos lottos) {
        return new LottosResponse(lottos);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
