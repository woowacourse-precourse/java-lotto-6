package lotto.domain;

import static lotto.constant.LottoNumber.PURCHASE_AMOUNT_COND;

import java.util.List;

public class LottoPurchase {

    private List<Lotto> purchaseLotto;
    private int amount;

    public void LottoPurchaseCreat(int purchaseMoney) {
        purchaseMoney /= PURCHASE_AMOUNT_COND.getNumber();
        this.amount = purchaseMoney;
    }

    public void getUserLotto(List<Lotto> purchaseLotto) {
        this.purchaseLotto = purchaseLotto;

    }

    public int getAmount() {
        return amount;
    }

    public List<Lotto> getPurchaseLotto() {
        return purchaseLotto;
    }
}
