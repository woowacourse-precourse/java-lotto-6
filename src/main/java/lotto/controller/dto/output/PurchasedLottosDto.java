package lotto.controller.dto.output;

import java.util.List;
import lotto.model.Lotto;

public record PurchasedLottosDto(List<Lotto> purchasedLottos) {
}
