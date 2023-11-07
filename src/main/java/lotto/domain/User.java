package lotto.domain;

import java.util.ArrayList;
import lotto.utils.Validation;

public class User {
    private final ArrayList<Lotto> lottos = new ArrayList<>();
    private final Amount purchaseAmount;

    public User(Amount purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public Amount getPurchaseAmount() {
        return purchaseAmount;
    }

    private void validatePurchaseAmount(Amount purchaseAmount) {
        Validation.validateNumberInRange(purchaseAmount.getAmount(), 1_000, 100_000);
        Validation.validateNumberMultipleOf(purchaseAmount.getAmount(), 1_000);
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
    public ArrayList<Lotto> getLottos() {
        return lottos;
    }
}
