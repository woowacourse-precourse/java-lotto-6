package lotto.controller;

import lotto.config.InputConfiguration;
import lotto.domain.LottoPurchase;
import lotto.domain.strategy.LottoNumberGenerator;
import lotto.util.handler.InputHandler;
import lotto.vo.TotalAmount;

public class PurchaseController {
    LottoNumberGenerator lottoNumberGenerator;
    private PurchaseController(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public static PurchaseController from(LottoNumberGenerator lottoNumberGenerator) {
        return new PurchaseController(lottoNumberGenerator);
    }

    public LottoPurchase processPurchase() {
        TotalAmount totalAmount = InputHandler.processInput(
                InputConfiguration.createAmountInputHandler(),
                TotalAmount::from
        );

        return LottoPurchase.from(totalAmount, lottoNumberGenerator);
    }
}
