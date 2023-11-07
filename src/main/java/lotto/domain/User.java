package lotto.domain;

import java.util.ArrayList;
import lotto.constants.LottoRules;
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
        Validation.validateNumberInRange(purchaseAmount.getAmount(), LottoRules.PURCHASE_AMOUNT_MIN.getValue(), LottoRules.PURCHASE_AMOUNT_MAX.getValue());
        Validation.validateNumberMultipleOf(purchaseAmount.getAmount(), LottoRules.LOTTO_PRICE.getValue());
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
    public ArrayList<Lotto> getLottos() {
        return lottos;
    }
}
