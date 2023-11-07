package lotto.Service;

import lotto.model.Rank;

import java.text.DecimalFormat;
import java.util.List;

public class ReturnCalcService {
    public int calculateTotalPrize(List<Integer> rankingResult){
        int totalPrize = 0;
        int rankingResultIdx = 5;
        for(Rank rank: Rank.values()){
            totalPrize += rank.getprizeMoney() * rankingResult.get(rankingResultIdx);
            rankingResultIdx--;
        }
        return totalPrize;
    }

    public String calculateReturnRate(int purchasePrice, int totalPrize){
        float originRate = (float)totalPrize / purchasePrice * 100;
        DecimalFormat df = new DecimalFormat("#.#");
        return df.format(originRate);
    }
}
