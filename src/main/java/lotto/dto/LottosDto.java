package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;

public class LottosDto {
    private final List<Lotto> lottos;

    public LottosDto(final Lottos lottos) {
        this.lottos = List.copyOf(lottos.lottoGroup());
    }

    public List<Lotto> getLottoGroup() {
        return lottos;
    }
}
