package lotto.domain;

import java.util.List;

public class LottoIntermediary {

    private final Buyer buyer;

    public LottoIntermediary(Buyer buyer) {
        this.buyer = buyer;
    }

    public void buyLottos(int purchaseAmount) {
        int purchasesNumber = calculatePurchasesNumber(purchaseAmount);
        List<Lotto> lottos = LottoIssuer.issue(purchasesNumber);
        buyer.buyLottos(purchaseAmount, lottos);
    }

    private int calculatePurchasesNumber(int purchaseAmount) {
        return purchaseAmount / Lotto.PRICE;
    }
}
