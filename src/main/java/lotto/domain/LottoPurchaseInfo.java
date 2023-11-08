package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseInfo {
    int purchaseAmount; // 구입한 금액
    int purchaseLottoCount; // 구입한 로또 갯수
    private final List<Lotto> lottos; // 구입한 모든 로또

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
        return purchaseAmount / LOTTO_PRICE;
    }
}
