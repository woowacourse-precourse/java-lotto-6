package lotto.domain;

import lotto.utils.LottoGenerator;

import static lotto.constants.LottoConstants.*;

public class LottoPurchaseManager {
    private final LottoPurchaseAmount purchaseAmount;
    private Lottos lottos;

    public LottoPurchaseManager(LottoPurchaseAmount lottoPurchaseAmount) {
        this.purchaseAmount = lottoPurchaseAmount;
        lottos = createLottos();
    }

    public static LottoPurchaseManager create(LottoPurchaseAmount lottoPurchaseAmount) {
        return new LottoPurchaseManager(lottoPurchaseAmount);
    }

    public LottoPurchaseAmount getPurchaseAmount() {
        return purchaseAmount;
    }

    public Lottos getLottos() {
        return lottos;
    }

    private Lottos createLottos() {
        long quantity = calculateLottoQuantity();
        return LottoGenerator.generateLottos(quantity);
    }

    private long calculateLottoQuantity() {
        return purchaseAmount.getAmount() / LOTTO_PRICE;
    }
}
