package lotto.model;

import java.util.List;
import lotto.dto.LottoInfoResponse;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoInfoResponse getLottoInfoResponse() {
        return new LottoInfoResponse(
            lottos.size(),
            lottos.stream().map(Lotto::getNumbers).toList()
        );
    }
}
