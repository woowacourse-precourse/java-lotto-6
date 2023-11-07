package lotto.service;

import lotto.domain.LottoMachine;
import lotto.domain.PurchasedLotto;
import lotto.dto.BuyLottoDTO;

public final class LottoBuyService {
    private final LottoMachine lottoMachine;

    public LottoBuyService(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public BuyLottoDTO.Output getPurchasedLottoDTO(Long buyPrice) {
        PurchasedLotto purchasedLotto = lottoMachine.generateForPrice(buyPrice);
        return new BuyLottoDTO.Output(purchasedLotto);
    }
}
