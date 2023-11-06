package lotto.domain;

import static lotto.enums.Prize.*;

import java.util.List;

public class Profit {


    private final int[] rank;
    private final List<Integer> rankMoney;
    private int totalProfitMoney;

    public Profit(int[] rank){
        this.rank = rank;
        rankMoney = List.of(0, FIRST_RANK.getMoney(), SECOND_RANK.getMoney(), THIRD_RANK.getMoney(),
                FOURTH_RANK.getMoney(), FIFTH_RANK.getMoney());
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
