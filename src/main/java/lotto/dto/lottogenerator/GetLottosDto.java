package lotto.dto.lottogenerator;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class GetLottosDto {
    private final Lottos lottos;

    public GetLottosDto(final List<Lotto> lottos) {
        this.lottos = new Lottos(lottos);
    }

    public Lottos getLottos() {
        return lottos;
    }

}
