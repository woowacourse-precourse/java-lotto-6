package lotto.game.controller;

import lotto.domain.Wallet;
import lotto.service.LottoProduceService;
import lotto.vo.Money;

public class WalletController {

    private final LottoProduceService lottoProduceService;

    public WalletController(LottoProduceService lottoProduceService) {
        this.lottoProduceService = lottoProduceService;
    }

    public Wallet make(Money money) {
        return lottoProduceService.produceLotto(money);
    }
}
