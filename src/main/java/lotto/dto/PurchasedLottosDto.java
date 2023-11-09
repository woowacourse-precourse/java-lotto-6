package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;


public class PurchasedLottosDto {
    private final Lottos lottos;

    private PurchasedLottosDto(Lottos lottos) {
        this.lottos = lottos;
    }

    public static PurchasedLottosDto from(Lottos lottos) {
        return new PurchasedLottosDto(lottos);
    }

    public long getSize() {
        return lottos.getSize();
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos.getLottos());
    }
}
