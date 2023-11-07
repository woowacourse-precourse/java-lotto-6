package lotto.domain;

import lotto.validation.Validation;

import java.util.ArrayList;
import java.util.HashMap;

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
        Validation.validateMinPurchaseAmount(purchaseAmount, MIN_AMOUNT);
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

    public long getPrizeSum(HashMap<PrizeTable, Integer> result) {
        long sum = 0;
        for (PrizeTable rank : result.keySet()) {
            sum += rank.getPrizeAmount() * result.get(rank);
        }
        return sum;
    }

    public double getYield(HashMap<PrizeTable, Integer> result) {
        double originYield = (getPrizeSum(result) / (double) purchaseAmount) * 100;
        double roundedYield = Math.round(originYield * 10) / 10.0;
        return roundedYield;
    }

}
