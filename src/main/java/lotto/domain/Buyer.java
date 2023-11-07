package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buyer {

    private final Map<Rank, Integer> resultRank = new HashMap<>();
    private final List<Lotto> purchasedLotto = new ArrayList<>();
    private final int purchaseAmount;

    private Buyer(int purchaseAmount) {
        initResultRank();
        this.purchaseAmount = purchaseAmount;
    }

    public static Buyer from(int purchaseAmount) {
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
}