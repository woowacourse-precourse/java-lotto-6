package domain;

import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private final ArrayList<Lotto> purchasedLotto = new ArrayList<>();
    private final HashMap<Rank, Integer> lottoResult = new HashMap<>();
    private final int purchaseAmount;

    public User(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public ArrayList<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }

    public HashMap<Rank, Integer> getLottoResult() {
        return lottoResult;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void purchaseLotto(Lotto lotto) {
        purchasedLotto.add(lotto);
    }

    public int getTotalPrize() {
        int sum = 0;
        for (Rank rank : lottoResult.keySet()) {
            sum += rank.getPrize() * lottoResult.get(rank);
        }
        return sum;
    }

    public double getLotteryReturns() {
        double lotteryReturns = (getTotalPrize() / (double) purchaseAmount) * 100;
        return Math.round(lotteryReturns * 10) / 10.0;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        Validations.validatePurchase(purchaseAmount);
        Validations.validateMaxPurchase(purchaseAmount);
        Validations.validateMinPurchase(purchaseAmount);
    }
}
