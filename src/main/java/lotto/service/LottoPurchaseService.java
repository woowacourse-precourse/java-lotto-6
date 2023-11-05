package lotto.service;

import lotto.domain.LottoMachine;
import lotto.domain.PurchasedLotto;
import lotto.dto.PurchasedLottoDTO;

public final class LottoPurchaseService {
    private final LottoMachine lottoMachine;
    private final Long totalPayPrice;

    public LottoPurchaseService(LottoMachine lottoMachine, Long totalPayPrice) {
        this.lottoMachine = lottoMachine;
        this.totalPayPrice = totalPayPrice;
    }

    public PurchasedLottoDTO.Output getPurchasedLottoDTO() {
        PurchasedLotto purchasedLotto = lottoMachine.generateForPrice(totalPayPrice);
        return new PurchasedLottoDTO.Output(purchasedLotto.lotto());
    }
}
