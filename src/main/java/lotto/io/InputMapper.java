package lotto.io;

import lotto.domain.LottoPurchasePrice;

public class InputMapper {

    public LottoPurchasePrice toLottoPurchasePrice(String lottoPurchasePrice) {
        Integer purchasePrice = Integer.parseInt(lottoPurchasePrice);
        return new LottoPurchasePrice(purchasePrice);
    }
}
