package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.dto.LottoDto;
import lotto.domain.dto.LottosDto;
import lotto.domain.dto.PurchaseAmountDto;

public class LottoMachine {

    public LottosDto issuedLottos(final PurchaseAmountDto purchaseAmountDto) {
        List<Lotto> lottos = new Lottos(purchaseAmountDto).getLottos();

        return new LottosDto(toLottoDto(lottos));
    }

    private List<LottoDto> toLottoDto(final List<Lotto> lottos) {
        List<LottoDto> lottoStore = new ArrayList<>();

        for (Lotto lotto : lottos) {
            LottoDto lottoDto = new LottoDto(lotto.getNumbers());
            lottoStore.add(lottoDto);
        }

        return lottoStore;
    }
}
