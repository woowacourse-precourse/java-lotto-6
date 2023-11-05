package lotto.domain;

import lotto.validator.LottoValidator;

import java.util.List;

public class LottoIntermediary {

    private final Buyer buyer;

    public LottoIntermediary(Buyer buyer) {
        this.buyer = buyer;
    }

    public void buyLotto(int purchaseAmount) {
        LottoValidator.validatePurchaseAmount(purchaseAmount);
        int purchasesNumber = calculatePurchasesNumber(purchaseAmount);
        List<Lotto> lottos = LottoIssuer.issue(purchasesNumber);
        buyer.buyLottos(purchaseAmount, lottos);
    }

    private int calculatePurchasesNumber(int purchaseAmount) {
        return purchaseAmount / Lotto.PRICE;
    }
}
