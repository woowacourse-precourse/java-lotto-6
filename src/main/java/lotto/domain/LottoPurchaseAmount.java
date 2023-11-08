package lotto.domain;

import static lotto.constants.DomainConstants.NO_CHANGE;
import static lotto.constants.DomainConstants.ONE_LOTTO_PURCHASE_AMOUNT;
import static lotto.exception.LottoException.CAN_NOT_GIVE_CHANGE;
import static lotto.exception.LottoException.CAN_NOT_PURCHASE_ONE_LOTTO;

public class LottoPurchaseAmount {

    private final int purchaseAmount;

    private LottoPurchaseAmount(final int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        validate();
    }

    public static LottoPurchaseAmount create(final int purchaseAmount) {
        return new LottoPurchaseAmount(purchaseAmount);
    }

    private void validate() {
        if (isCanNotPurchaseOneLotto()) {
            CAN_NOT_PURCHASE_ONE_LOTTO.create();
        }
        if (hasChange()) {
            CAN_NOT_GIVE_CHANGE.create();
        }
    }

    private boolean isCanNotPurchaseOneLotto() {
        return purchaseAmount < ONE_LOTTO_PURCHASE_AMOUNT.getValue();
    }

    private boolean hasChange() {
        return purchaseAmount % ONE_LOTTO_PURCHASE_AMOUNT.getValue() != NO_CHANGE.getValue();
    }

    public Count getLottoCount() {
        int count = purchaseAmount / ONE_LOTTO_PURCHASE_AMOUNT.getValue();
        return new Count(count);
    }
}
