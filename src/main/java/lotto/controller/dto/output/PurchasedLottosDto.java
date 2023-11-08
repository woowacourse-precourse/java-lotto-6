package lotto.controller.dto.output;

import java.util.Collections;
import java.util.List;
import lotto.model.lotto.Lotto;

public record PurchasedLottosDto(List<Lotto> purchasedLottos) {
    public PurchasedLottosDto(List<Lotto> purchasedLottos) {
        this.purchasedLottos = Collections.unmodifiableList(purchasedLottos);
    }
}
