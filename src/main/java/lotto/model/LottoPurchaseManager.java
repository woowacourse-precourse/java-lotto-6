package lotto.model;

import lotto.system.util.LottoNumberGenerator;

public class LottoPurchaseManager {
    private static final int LOTTO_PRICE = 1000;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoPurchaseManager(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public int calculatePurchaseQuantity(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
