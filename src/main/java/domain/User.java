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
        initLottoResult();
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

    public long getTotalPrize() {
        long sum = 0L;
        for (Rank rank : lottoResult.keySet()) {
            sum += rank.getPrize() * lottoResult.get(rank);
        }
        return sum;
    }

    public double getLotteryReturns() {
        double lotteryReturns = (getTotalPrize() / (double) purchaseAmount) * 100;
        return Math.round(lotteryReturns * 10) / 10.0;
    }

    private void initLottoResult() {
        lottoResult.put(Rank.FIRST, 0);
        lottoResult.put(Rank.SECOND, 0);
        lottoResult.put(Rank.THIRD, 0);
        lottoResult.put(Rank.FOURTH, 0);
        lottoResult.put(Rank.FIFTH, 0);
        lottoResult.put(Rank.TWO_MATCH, 0);
        lottoResult.put(Rank.ONE_MATCH, 0);
        lottoResult.put(Rank.ZERO_MATCH, 0);
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        Validations.validatePurchase(purchaseAmount);
        Validations.validateMaxPurchase(purchaseAmount);
        Validations.validateMinPurchase(purchaseAmount);
    }
}
