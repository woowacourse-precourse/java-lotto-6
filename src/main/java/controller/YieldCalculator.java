package controller;

import model.Rank;
import model.Ranking;

import java.util.List;

public class YieldCalculator {


    public static int totalPrize(Ranking ranking){
        int sum = 0;
        for(int prizeRank : ranking.getWinningDetails()){
            sum += matchRank(prizeRank);
        }
        return sum;
    }
    private static int matchRank(int prizeRank){
        Rank rank = null;
        for(Rank r : Rank.values()){
            if(r.getRank() == prizeRank){
                rank = r;
                break;
            }
        }
        if(rank == null){
            return 0;
        }
        return rank.getPrice();
    }
}
