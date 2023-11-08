package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottosDto {
    private final List<Lotto> lotto;

    private LottosDto(List<Lotto> lotto) {
        this.lotto = lotto;
    }

    public static LottosDto from(Lottos lottos) {
        return new LottosDto(lottos.getLottos());
    }

    public List<Lotto> getLotto() {
        return lotto;
    }
}
