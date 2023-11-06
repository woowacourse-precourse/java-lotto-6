package lotto.controller;

import lotto.service.LottteryService;

import java.util.Map;

public class LottoPaymentController implements BasicController{
    private final LottteryService lottteryService = new LottteryService();

    @Override
    public String handle(Map<String, Object> model) throws IllegalArgumentException{
        lottteryService.lottoPayment((String) model.get("desiredPurchaseAmount"));
        return null;
    }
}
