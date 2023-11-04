package lotto.controller;

import lotto.service.LottoPublishService;
import lotto.utils.ExceptionMessage;

public class LottoController {

    private final LottoPublishService lottoPublishService;

    public LottoController(LottoPublishService lottoPublishService) {
        this.lottoPublishService = lottoPublishService;
    }

    public void publishLotto(String inputPurchaseAmount) throws IllegalArgumentException {
        int purchaseAmount = validatePurchaseAmountType(inputPurchaseAmount);
        lottoPublishService.publish(purchaseAmount);

    }

    private int validatePurchaseAmountType(String inputPurchaseAmount) {
        try {
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_BUY_AMOUNT_TYPE);
        }
    }
}
