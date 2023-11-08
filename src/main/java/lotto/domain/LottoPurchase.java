package lotto.domain;

import static lotto.constant.LottoNumber.PURCHASE_AMOUNT_COND;

import java.util.List;
import lotto.constant.message.ExceptionMessage;

public class LottoPurchase {

    private List<Lotto> purchaseLotto;
    private int amount;

    public void LottoPurchaseCreat(int purchaseMoney) {
        if (purchaseMoney % PURCHASE_AMOUNT_COND.getNumber() != 0) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_ERROR.getMessage());
        }
        this.amount = purchaseMoney / PURCHASE_AMOUNT_COND.getNumber();
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
