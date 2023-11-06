package lotto.service;

import lotto.dto.LottoPurchaseDto;
import lotto.model.LottoPurchaseAmount;
import lotto.model.LottoPurchaseQuantity;

public class LotteryService implements Service {
    private LotteryService() {
    }

    public static LotteryService create() {
        return new LotteryService();
    }

    @Override
    public LottoPurchaseDto buyLottery(final String inputPurchaseAmount) {
        LottoPurchaseAmount amount = LottoPurchaseAmount.from(inputPurchaseAmount);
        LottoPurchaseQuantity quantity = amount.getLottoPurchaseQuantity();

        return getLottoPurchaseDto(amount, quantity);
    }

    private LottoPurchaseDto getLottoPurchaseDto(LottoPurchaseAmount amount, LottoPurchaseQuantity quantity) {
        return new LottoPurchaseDto(amount.getAmount(), quantity.quantity());
    }
}
