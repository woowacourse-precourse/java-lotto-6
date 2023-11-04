package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.RnadomNumberGenerator;

public class UserService {
    private PurchaseAmount purchaseAmount;
    private final List<Lotto> lottos = new ArrayList<>();

    public void validatePurchaseAmount(String purchaseAmountInput) {
        purchaseAmount = PurchaseAmount.create(purchaseAmountInput);
    }

    public void purchaseLottos() {
        for (int i = 0; i < calculateNumberOfPurchase(); i++) {
            List<Integer> randomNumbers = RnadomNumberGenerator.generateUniqueSixNumber();
            lottos.add(new Lotto(randomNumbers));
        }
    }

    private Integer calculateNumberOfPurchase() {
        return purchaseAmount.getPurchaseAmount() / Lotto.PRICE;
    }
}
