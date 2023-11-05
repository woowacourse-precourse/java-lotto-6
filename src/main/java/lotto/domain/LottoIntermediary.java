package lotto.domain;

import java.util.List;

public class LottoIntermediary {

    private Buyer buyer;

    public void buyLottos(int purchaseAmount) {
        int purchasesNumber = calculatePurchasesNumber(purchaseAmount);
        List<Lotto> lottos = LottoIssuer.issue(purchasesNumber);
        buyer = new Buyer(purchaseAmount, lottos);
    }

    private int calculatePurchasesNumber(int purchaseAmount) {
        return purchaseAmount / Lotto.PRICE;
    }
}
