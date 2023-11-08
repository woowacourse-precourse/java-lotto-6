package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Customer {
    private static final int initLottoRanking = 0;
    private static final double percent = 100.0;
    private static final int intTen = 10;
    private static final double doubleTen = 10.0;
    private static final int zero = 0;
    private int purchaseMoney;
    private ArrayList<Lotto> purchaseLotteries = new ArrayList<>();
    private HashMap<Ranking,Integer> lottoResult = new HashMap<>();

    public Customer(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
        initLottoResult();
    }

    public int getPurchaseMoney() {
        return this.purchaseMoney;
    }

    public void buyLotto(Lotto lotto) {
        purchaseLotteries.add(lotto);
    }

    public ArrayList<Lotto> getPurchaseLotteries() {
        return purchaseLotteries;
    }

    public HashMap<Ranking,Integer> getLottoResult(){
        return lottoResult;
    }

    private void initLottoResult(){
        lottoResult.put(Ranking.ZERO, initLottoRanking);
        lottoResult.put(Ranking.ONE, initLottoRanking);
        lottoResult.put(Ranking.TWO, initLottoRanking);
        lottoResult.put(Ranking.THREE, initLottoRanking);
        lottoResult.put(Ranking.FOUR, initLottoRanking);
        lottoResult.put(Ranking.FIVE, initLottoRanking);
        lottoResult.put(Ranking.FIVE_BONUS, initLottoRanking);
        lottoResult.put(Ranking.SIXTH, initLottoRanking);
    }

    public double getYield(){
        double yield = (getResultSum() / (double) purchaseMoney) * percent;
        double roundedYield = Math.round(yield * intTen) / doubleTen;
        return roundedYield;
    }

    public int getResultSum() {
        int sum = zero;
        for(Ranking ranking : lottoResult.keySet()) {
            sum += ranking.getReward() * lottoResult.get(ranking);
        }
        return sum;
    }
}
