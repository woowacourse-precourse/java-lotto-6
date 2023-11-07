package lotto.domain;

import static lotto.enums.LottoRank.*;

import java.util.HashMap;
import java.util.List;
import lotto.enums.LottoRank;

public class WinningDetails {
    private final List<Lotto> lottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private final HashMap<Integer,Integer> rank;

    public WinningDetails(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.rank = initRank();
        checkWinningCount();
    }

    public HashMap<Integer,Integer> getRank(){
        return rank;
    }

    private HashMap<Integer, Integer> initRank(){

        HashMap<Integer,Integer> initialRank = new HashMap<>();

        for (int i = FIRST_RANK.getRank(); i <= FIFTH_RANK.getRank(); i++) {
            initialRank.put(i,0);
        }

        return initialRank;
    }

    private void checkWinningCount(){
        for (Lotto lotto: lottos) {
            int matchNumbers = getMatchWinningNumber(lotto);
            boolean bonusMatch = isBonusMatch(matchNumbers,lotto);
            checkMatchNumbersPerLotto(matchNumbers,bonusMatch);
        }
    }

    private boolean isBonusMatch(int matchNumbers, Lotto lotto){
        return matchNumbers == SECOND_RANK.getMatchNumbers() && lotto.getNumbers().contains(bonusNumber);
    }

    private int getMatchWinningNumber(Lotto lotto){
        return (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
    }

    private void checkMatchNumbersPerLotto(int matchNumbers, boolean bonusMatch){

        for(LottoRank rank: LottoRank.values()){
            if(isRankMatch(rank,matchNumbers,bonusMatch)){
                incrementRankCount(rank);
            }
        }
    }

    private boolean isRankMatch(LottoRank rank, int matchNumbers, boolean bonusMatch){
        return rank.getMatchNumbers() == matchNumbers && rank.isBonusMatch() == bonusMatch;
    }

    private void incrementRankCount(LottoRank lottoRank){
        rank.put(lottoRank.getRank(), rank.getOrDefault(lottoRank.getRank(),0)+1);
    }
}
