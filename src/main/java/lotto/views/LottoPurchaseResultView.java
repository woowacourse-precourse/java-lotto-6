package lotto.views;

import lotto.constants.StringConstants;
import lotto.domain.LottoPurchase;

public class LottoPurchaseResultView implements View<Void> {
    private final LottoPurchase lottoPurchase;

    public LottoPurchaseResultView(LottoPurchase lottoPurchase) {
        this.lottoPurchase = lottoPurchase;
    }

    @Override
    public Void render() {
        var purchasedLottos = lottoPurchase.getPurchasedLottos();
        System.out.printf(StringConstants.BUY_FORMAT_MESSAGE + "\n", purchasedLottos.size());
        for (var lotto : purchasedLottos) {
            System.out.println(lotto);
        }
        return null;
    }
}
