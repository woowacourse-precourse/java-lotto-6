package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResultWinners {
    Map<Rank,Integer> lottoResultWinner;

    public LottoResultWinners(){
        this.lottoResultWinner = new HashMap<>();
    }

    public void add(LottoResult lottoResult) {
        for (Rank rank : Rank.values()){
            if(!checkWinner(lottoResult,rank)){
                continue;
            }
            if(lottoResultWinner.containsKey(rank)){
                Integer currentValue = lottoResultWinner.get(rank);
                lottoResultWinner.put(rank, currentValue + 1);
            } else if (!lottoResultWinner.containsKey(rank)) {
                lottoResultWinner.put(rank, 1);
            }
        }
    }

    private Boolean checkWinner(LottoResult lottoResult, Rank rank) {
        if(lottoResult.getNumberOfMatch() == rank.getNumberOfMatch()){
            if(isNotSameFiveMatchBonus(lottoResult,rank)){
                return false;
            }
            return true;
        }
        return false;
    }

    private Boolean isNotSameFiveMatchBonus(LottoResult lottoResult,Rank rank){
        return lottoResult.getNumberOfMatch() == Rank.FIVE_MATCH_BONUS.getNumberOfMatch()
                && lottoResult.getBonus() != rank.getBonus();
    }

}
