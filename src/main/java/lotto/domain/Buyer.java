package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.view.ErrorMessage;

public class Buyer {
    private static final int PURCHASE_AMOUNT_UNIT = 1000;

    private final Map<Rank, Integer> resultRank = new HashMap<>();
    private final List<Lotto> purchasedLotto = new ArrayList<>();
    private final int purchaseAmount;

    private Buyer(int purchaseAmount) {
        initResultRank();
        this.purchaseAmount = purchaseAmount;
    }

    public static Buyer from(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return new Buyer(purchaseAmount);
    }

    public void buyLotto(Lotto lotto) {
        purchasedLotto.add(lotto);
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public Map<Rank, Integer> getResultRank() {
        return resultRank;
    }

    private void initResultRank() {
        resultRank.put(Rank.FIFTH, 0);
        resultRank.put(Rank.FORTH, 0);
        resultRank.put(Rank.THIRD, 0);
        resultRank.put(Rank.SECOND, 0);
        resultRank.put(Rank.FIRST, 0);
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % PURCHASE_AMOUNT_UNIT != 0) {
            ErrorMessage.divideNumberError(PURCHASE_AMOUNT_UNIT);
            throw new IllegalArgumentException();
        }
    }
}