package lotto.dto.generate;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class GetGeneratedLottosDto {
    private final Lottos lottos;

    public GetGeneratedLottosDto(final List<Lotto> lottos) {
        this.lottos = new Lottos(lottos);
    }

    public Lottos getLottos() {
        return lottos;
    }

}
