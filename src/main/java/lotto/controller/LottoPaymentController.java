package lotto.controller;

import lotto.service.LotteryService;

import java.util.Map;

public class LottoPaymentController implements BasicController{
    private final LotteryService lotteryService = LotteryService.getInstance();

    @Override
    public String handle(Map<String, Object> model) throws IllegalArgumentException{
        lotteryService.lottoPayment((String) model.get("desiredPurchaseAmount"));
        return null;
    }
}
