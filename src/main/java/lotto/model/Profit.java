package lotto.model;

import java.util.List;

public class Profit {

    private static final int FIFTH_PLACE_MONEY = 5_000;
    private static final int FOURTH_PLACE_MONEY = 50_000;
    private static final int THIRD_PLACE_MONEY = 1_500_000;
    private static final int SECOND_PLACE_MONEY = 30_000_000;
    private static final int FIRST_PLACE_MONEY = 2_000_000_000;

    private final int[] rank;
    private final List<Integer> rankMoney;
    private int totalProfitMoney;

    public Profit(int[] rank){
        this.rank = rank;
        rankMoney = List.of(0,FIRST_PLACE_MONEY, SECOND_PLACE_MONEY, THIRD_PLACE_MONEY, FOURTH_PLACE_MONEY, FIFTH_PLACE_MONEY);
    }

    public float getTotalEarningRate(int purchaseMoney){
        setTotalWinningMoney();
        return (float) totalProfitMoney/purchaseMoney*100;
    }

    private int setTotalWinningMoney(){

        for (int i = 0; i < rank.length; i++) {
            if(rank[i] > 0){
                totalProfitMoney += rank[i] * rankMoney.get(i);
            }
        }

        return totalProfitMoney;
    }
}
