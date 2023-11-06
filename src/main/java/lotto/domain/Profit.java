package lotto.domain;

import static lotto.enums.Constants.*;
import static lotto.enums.Prize.*;

import java.util.HashMap;

public class Profit {

    private final HashMap<Integer,Integer> rank;
    private HashMap<Integer,Integer> rankMoney;
    private int totalProfitMoney;

    public Profit(HashMap<Integer,Integer> rank){
        this.rank = new HashMap<>(rank);
        this.rankMoney = new HashMap<>();
        initRankMoney();
    }

    public float getTotalEarningRate(int purchaseMoney){
        setTotalWinningMoney();
        return (float) totalProfitMoney/purchaseMoney*PROFIT_PERCENT.getValue();
    }

    private void initRankMoney(){
        rankMoney.put(FIRST_RANK.getRank(),FIRST_RANK.getMoney());
        rankMoney.put(SECOND_RANK.getRank(), SECOND_RANK.getMoney());
        rankMoney.put(THIRD_RANK.getRank(), THIRD_RANK.getMoney());
        rankMoney.put(FOURTH_RANK.getRank(), FOURTH_RANK.getMoney());
        rankMoney.put(FIFTH_RANK.getRank(), FIFTH_RANK.getMoney());
    }

    private int setTotalWinningMoney(){

        for(Integer key: rank.keySet()){
            if(rank.get(key) > 0){
                totalProfitMoney += rank.get(key) * rankMoney.get(key);
            }
        }

        return totalProfitMoney;
    }
}
