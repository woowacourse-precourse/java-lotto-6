package domain;

import java.util.ArrayList;

public class User {

    private final ArrayList<Lotto> purchasedLotto = new ArrayList<>();
    private final int purchaseAmount;

    public User(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public void purchaseLotto(Lotto lotto) {
        purchasedLotto.add(lotto);
    }

    public ArrayList<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public double getLotteryReturns() {
        return 0;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        Validations.validatePurchase(purchaseAmount);
        Validations.validateMaxPurchase(purchaseAmount);
        Validations.validateMinPurchase(purchaseAmount);
    }
}
