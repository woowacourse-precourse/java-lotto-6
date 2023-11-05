package lotto.controller.dto.output;

import java.util.List;
import lotto.Lotto;

public record PurchasedLottosDto(List<Lotto> purchasedLottos) {
}
