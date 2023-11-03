package lotto.model;

import static lotto.constant.LottoRuleConstant.LOTTO_MAX_PURCHASE_AMOUNT;
import static lotto.constant.LottoRuleConstant.LOTTO_PURCHASE_AMOUNT_MOD_RESULT;
import static lotto.constant.LottoRuleConstant.LOTTO_UNIT_PRICE;

public class PurchaseAmount {
    private int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);

        this.purchaseAmount = purchaseAmount;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        checkRange(purchaseAmount);
        checkUnit(purchaseAmount);
    }

    private void checkRange(int purchaseAmount) {
        checkMinimum(purchaseAmount);
        checkMaximum(purchaseAmount);
    }

    private void checkMinimum(int purchaseAmount) {
        if (purchaseAmount < LOTTO_UNIT_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또 1장 가격인 1,000원 이상 입력해 주세요.");
        }
    }

    private void checkMaximum(int purchaseAmount) {
        if (purchaseAmount > LOTTO_MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 1회 최대 100,000원까지만 구매가 가능합니다.");
        }
    }

    private void checkUnit(int purchaseAmount) {
        if (purchaseAmount % LOTTO_UNIT_PRICE != LOTTO_PURCHASE_AMOUNT_MOD_RESULT) {
            throw new IllegalArgumentException("[ERROR] 로또 1장 가격인 1,000원 단위로만 구매가 가능합니다.");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
