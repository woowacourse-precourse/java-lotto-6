package lotto.controller;

import lotto.domain.LottoCollector;
import lotto.service.LottoPublishService;
import lotto.utils.ExceptionMessage;

public class LottoController {

    private final LottoPublishService lottoPublishService;

    public LottoController(LottoPublishService lottoPublishService) {
        this.lottoPublishService = lottoPublishService;
    }

    public LottoCollector publishLotto(String inputPurchaseAmount) throws IllegalArgumentException {
        int purchaseAmount = validatePurchaseAmountType(inputPurchaseAmount);

        return lottoPublishService.publish(purchaseAmount);
    }

    private int validatePurchaseAmountType(String inputPurchaseAmount) {
        try {
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_BUY_AMOUNT_TYPE);
        }
    }
}
