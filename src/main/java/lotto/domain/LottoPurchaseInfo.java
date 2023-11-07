package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseInfo {
    int purchaseAmount;
    int purchaseLottoCount;
    private final List<Lotto> lottos;

    public LottoPurchaseInfo(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.purchaseLottoCount = makePurchaseLottoCount(purchaseAmount);
        this.lottos = new ArrayList<>();
        for (int i = 0; i < purchaseLottoCount; i++) {
            this.lottos.add(new Lotto());
        }
    }

    public int getPurchaseLottoCount() {
        return this.purchaseLottoCount;
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public int makePurchaseLottoCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }
}
