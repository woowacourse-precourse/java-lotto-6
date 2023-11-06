package lotto.domain;

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
        if(matchNumbers == 3 && !bonusMatch){
            rank[5]++;
        }

        if(matchNumbers == 4 && !bonusMatch){
            rank[4]++;
        }

        if(matchNumbers == 5 && !bonusMatch){
            rank[3]++;
        }

        if(matchNumbers == 5 && bonusMatch){
            rank[2]++;
        }

        if(matchNumbers == 6){
            rank[1]++;
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
