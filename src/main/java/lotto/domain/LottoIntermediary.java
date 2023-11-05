package lotto.domain;

import lotto.dto.LottoNumbers;
import lotto.dto.PurchasedLotto;
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
        buyer.buyLotto(purchaseAmount, lottos);
    }

    private int calculatePurchasesNumber(int purchaseAmount) {
        return purchaseAmount / Lotto.PRICE;
    }

    public PurchasedLotto getPurchasedLotto() {
        List<Lotto> purchasedLottos = buyer.getLottos();
        List<LottoNumbers> lottos = purchasedLottos.stream()
                .map(Lotto::getNumbers)
                .toList();
        return new PurchasedLotto(purchasedLottos.size(), lottos);
    }
}
