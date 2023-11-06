package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResultWinners {
    private Map<Rank,Integer> lottoResultWinner;

    public LottoResultWinners(){
        this.lottoResultWinner = new HashMap<>();
        for (Rank rank : Rank.values()) {
            lottoResultWinner.put(rank, 0);
        }
    }

    public void add(LottoResult lottoResult) {
        for (Rank rank : Rank.values()){
            if(!checkWinner(lottoResult,rank)){
                continue;
            }
            Integer currentValue = lottoResultWinner.get(rank);
            lottoResultWinner.put(rank, currentValue + 1);
            continue;
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
