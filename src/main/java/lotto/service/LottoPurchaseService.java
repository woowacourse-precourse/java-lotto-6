package lotto.service;

import lotto.domain.LottoMachine;
import lotto.domain.PurchasedLotto;
import lotto.dto.BuyLottoDTO;

public final class LottoPurchaseService {
    private final LottoMachine lottoMachine;
    private final Long buyPrice;

    public LottoPurchaseService(LottoMachine lottoMachine, Long buyPrice) {
        this.lottoMachine = lottoMachine;
        this.buyPrice = buyPrice;
    }

    public BuyLottoDTO.Output getPurchasedLottoDTO() {
        PurchasedLotto purchasedLotto = lottoMachine.generateForPrice(buyPrice);
        return new BuyLottoDTO.Output(purchasedLotto);
    }
}
