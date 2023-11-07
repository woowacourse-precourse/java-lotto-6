package lotto.domain;

import static lotto.enums.Constants.*;

import java.util.HashMap;
import lotto.enums.LottoRank;

public class Profit {

    private final HashMap<Integer,Integer> rank;
    private final HashMap<Integer,Integer> rankMoney;
    private int totalProfitMoney;

    public Profit(HashMap<Integer,Integer> rank){
        this.rank = rank;
        this.rankMoney = initRankMoney();
    }

    public float getTotalEarningRate(int purchaseMoney){
        setTotalWinningMoney();
        return (float) totalProfitMoney/purchaseMoney*PROFIT_PERCENT.getValue();
    }

    private HashMap<Integer,Integer> initRankMoney(){

        HashMap<Integer,Integer> initialRankMoney = new HashMap<>();

        for(LottoRank rank : LottoRank.values()) {
            initialRankMoney.put(rank.getRank(), rank.getMoney());
        }

        return initialRankMoney;
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
