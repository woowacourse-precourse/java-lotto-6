package lotto.dto;

import java.util.List;
import lotto.Lotto;

public class LottoNumberDto {
    private final List<Lotto> lottos;

    public LottoNumberDto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
