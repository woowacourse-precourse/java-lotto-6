package lotto.domain;

import java.util.List;

public class LottoIntermediary {

    private Buyer buyer;

    public void buyLottos(int purchaseAmount) {
        int purchasesNumber = purchaseAmount / Lotto.PRICE;
        List<Lotto> lottos = LottoIssuer.issue(purchasesNumber);
        buyer = new Buyer(purchaseAmount, lottos);
    }
}
