package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.dto.LottosDto;
import lotto.domain.dto.PurchaseAmountDto;

public class LottoMachine {

    public LottosDto issuedLottos(final PurchaseAmountDto purchaseAmountDto) {
        List<Lotto> lottos = new Lottos(purchaseAmountDto).getLottos();

        return new LottosDto(lottos);
    }
}
