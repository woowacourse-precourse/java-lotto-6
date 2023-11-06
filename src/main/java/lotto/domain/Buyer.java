package lotto.domain;

import lotto.validation.Validation;

import java.util.ArrayList;

public class Buyer {
    private final ArrayList<Lotto> purchasedLotteries = new ArrayList<>();
    public static final int UNIT = 1000;
    public static final int MIN_AMOUNT = 1000;
    private int purchaseAmount;

    public Buyer(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        Validation.ValidateMinPurchaseAmount(purchaseAmount, MIN_AMOUNT);
        Validation.validateAmountUnit(purchaseAmount, UNIT);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public ArrayList<Lotto> getPurchasedLotteries() {
        return purchasedLotteries;
    }

    public void buyLotto(Lotto lotto) {
        purchasedLotteries.add(lotto);
    }
}
