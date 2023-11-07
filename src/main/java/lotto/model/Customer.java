package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Customer {

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
        lottoResult.put(Ranking.ZERO, 0);
        lottoResult.put(Ranking.ONE, 0);
        lottoResult.put(Ranking.TWO, 0);
        lottoResult.put(Ranking.THREE, 0);
        lottoResult.put(Ranking.FOUR, 0);
        lottoResult.put(Ranking.FIVE, 0);
        lottoResult.put(Ranking.FIVE_BONUS, 0);
        lottoResult.put(Ranking.SIXTH, 0);
    }

    public double getYield(){
        double yield = (getResultSum() / (double) purchaseMoney) * 100.0;
        double roundedYield = Math.round(yield * 10) / 10.0;
        return roundedYield;
    }

    public int getResultSum() {
        int sum = 0;
        for(Ranking ranking : lottoResult.keySet()) {
            sum += ranking.getReward() * lottoResult.get(ranking);
        }
        return sum;
    }

}
