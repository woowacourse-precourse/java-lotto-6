package lotto.domain;

import java.util.ArrayList;
import lotto.utils.Validation;

public class User {
    private final ArrayList<Lotto> lottos = new ArrayList<>();
    private final int purchaseAmount;

    public User(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        Validation.validateNumberInRange(purchaseAmount, 1_000, 100_000);
        Validation.validateNumberMultipleOf(purchaseAmount, 1_000);
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
    public ArrayList<Lotto> getLottos() {
        return lottos;
    }
}
