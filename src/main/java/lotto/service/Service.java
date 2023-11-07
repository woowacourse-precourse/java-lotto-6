package lotto.service;

import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.dto.PurchaseResult;
import lotto.util.Utils;

public class Service {
    private static final int MINIMUM_AMOUNT = 1000;

    public PurchaseResult purchaseLottos(Buyer buyer) {
        int lottoCount = buyer.getAmount() / MINIMUM_AMOUNT;
        for (int i = 0; i < lottoCount; i++) {
            purchaseLotto(buyer);
        }

        return new PurchaseResult(buyer.getLottos());
    }

    private void purchaseLotto(Buyer buyer) {
        Lotto lotto = createLottoNumbers();
        buyer.setLottos(lotto);
    }

    private Lotto createLottoNumbers() {
        List<Integer> generatedNumbers = Utils.createSortedLottoNumbers();
        return new Lotto(generatedNumbers);
    }
}
