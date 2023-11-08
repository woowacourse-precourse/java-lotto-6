package lotto.dto.domain.lottos;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class GetLottosDto {

    private final List<Lotto> lottos;

    public GetLottosDto(final Lottos lottos) {
        this.lottos = lottos.lottos();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
