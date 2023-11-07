package lotto.model;

import lotto.system.util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseManager {
    private static final int LOTTO_PRICE = 1000;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoPurchaseManager(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public int calculatePurchaseQuantity(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public List<LottoPaper> purchaseLottoPapers(int quantity) {
        List<LottoPaper> purchasedLottoPapers = new ArrayList<>(quantity);
        for (int purchaseIndex = 0; purchaseIndex < quantity; purchaseIndex++) {
            Lotto lotto = new Lotto(lottoNumberGenerator.generate());
            LottoPaper lottoPaper = lotto.toLottoPaper();

            purchasedLottoPapers.add(lottoPaper);
        }

        return purchasedLottoPapers;
    }
}
