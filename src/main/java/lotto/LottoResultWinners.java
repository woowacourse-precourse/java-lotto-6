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

    public static LottoResultWinners findWinnerOfLotto(Lottos lottos, Lotto winningNumbers, Integer bonusNumber) {
        LottoResultWinners lottoResultWinners = new LottoResultWinners();
        for (Integer lottoIndex = 0; lottoIndex < lottos.getSize(); lottoIndex++) {
            Lotto lotto = lottos.getLotto(lottoIndex);
            LottoResult lottoResult = compareLottoToWinningNumber(lotto,winningNumbers,bonusNumber);
            lottoResultWinners.add(lottoResult);
        }
        return lottoResultWinners;
    }

    public static LottoResult compareLottoToWinningNumber(Lotto lotto,Lotto winningNumbers,Integer bonusNumber){
        Integer numberOfMatch = 0;
        Boolean bonus = false;
        for (Integer numberIndex = 0; numberIndex < lotto.getSize(); numberIndex++) {
            if (lotto.contains(winningNumbers.getNumber(numberIndex))) {
                numberOfMatch++;
            }
            if(lotto.contains(bonusNumber)){
                bonus = true;
            }
        }
        return new LottoResult(numberOfMatch,bonus);
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

    public Integer getNumberOfWinner(Rank rank) {
        return lottoResultWinner.get(rank);
    }

}
