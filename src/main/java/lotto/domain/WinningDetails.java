package lotto.domain;

import static lotto.enums.Constants.*;

import java.util.List;

public class WinningDetails {
    private final List<Lotto> lottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private int[] rank;
    private boolean bonusMatch;

    public WinningDetails(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        rank = new int[6];

        checkWinningCount();
    }

    public int[] getRank(){
        return rank;
    }

    private void checkWinningCount(){
        for (Lotto lotto: lottos) {
            checkMatchNumbersPerLotto(getMatchWinningNumber(lotto));
            bonusMatch = false;
        }
    }

    private int getMatchWinningNumber(Lotto lotto){
        int matchNumers = 0;
        List<Integer> lottoNumbers = lotto.getNumbers();

        for (Integer number: lottoNumbers) {
            if(winningNumbers.contains(number)) matchNumers++;
        }

        if(matchNumers == 5){
            checkBonusMatch(lottoNumbers);
        }

        return matchNumers;
    }

    private void checkMatchNumbersPerLotto(int matchNumbers){
        if(matchNumbers == RANK_FIVE_NUMBER_MATCHES.getValue() && !bonusMatch){
            rank[RANK_FIVE.getValue()]++;
        }

        if(matchNumbers == RANK_FOUR_NUMBER_MATCHES.getValue() && !bonusMatch){
            rank[RANK_FOUR.getValue()]++;
        }

        if(matchNumbers == RANK_THREE_NUMBER_MATCHES.getValue() && !bonusMatch){
            rank[RANK_THREE.getValue()]++;
        }

        if(matchNumbers == RANK_TWO_NUMBER_MATCHES.getValue() && bonusMatch){
            rank[RANK_TWO.getValue()]++;
        }

        if(matchNumbers == RANK_ONE_NUMBER_MATCHES.getValue()){
            rank[RANK_ONE.getValue()]++;
        }
    }

    private void checkBonusMatch(List<Integer> numbers){
        if(numbers.contains(bonusNumber)){
            bonusMatch = true;
            return;
        }
        bonusMatch = false;
    }
}
