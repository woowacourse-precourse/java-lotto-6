package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private final ArrayList<Lotto> purchasedLotteries = new ArrayList<>();

    private final HashMap<Rank, Integer> lottoResult = new HashMap<>();
    private int purchaseAmount;

    private static final int INIT_SUM = 0;
    private static final int ROUND_CONSTANT_INT_TEN = 10;
    private static final double ROUND_CONSTANT_DOUBLE_TEN = 10.0;
    private static final double PERCENT = 100;




    public User(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        initLottoResult();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void buyLotto(Lotto lotto) {
        purchasedLotteries.add(lotto);
    }

    public ArrayList<Lotto> getPurchasedLotteries() {
        return purchasedLotteries;
    }


    public HashMap<Rank, Integer> getLottoResult() {
        return lottoResult;
    }

    public long sumOfPrize(){
        long sum = INIT_SUM;
        for(Rank rank : lottoResult.keySet()){
            sum += rank.getPrize() * lottoResult.get(rank);
        }
        return sum;
    }

    public double getRateOfReturn(User user){
        double origin = (sumOfPrize() /  (double) user.getPurchaseAmount()) * PERCENT;
        double round = Math.round(origin * ROUND_CONSTANT_INT_TEN) / ROUND_CONSTANT_DOUBLE_TEN;
        return round;
    }
    private void initLottoResult() {
        lottoResult.put(Rank.FIRST, 0);
        lottoResult.put(Rank.SECOND, 0);
        lottoResult.put(Rank.THIRD, 0);
        lottoResult.put(Rank.FOURTH, 0);
        lottoResult.put(Rank.FIFTH, 0);
        lottoResult.put(Rank.NO_RANK_TWO, 0);
        lottoResult.put(Rank.NO_RANK_ONE, 0);
        lottoResult.put(Rank.NO_RANK_ZERO, 0);
    }



}
