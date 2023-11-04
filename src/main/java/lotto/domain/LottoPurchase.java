package lotto.domain;

import static lotto.constant.LottoNumber.PURCHASE_AMOUNT_COND;

public class LottoPurchase {
    private int amount;

    public LottoPurchase(int purchaseMoney) {
        LottoPurchaseCreat(purchaseMoney);
    }

    private void LottoPurchaseCreat (int purchaseMoney){
        purchaseMoney /= PURCHASE_AMOUNT_COND.getNumber();
        this.amount = purchaseMoney;
    }

    public int getAmount() {
        return amount;
    }
}
