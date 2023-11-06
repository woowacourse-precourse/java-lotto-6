package lotto.domain;

import static lotto.enums.Prize.*;

import java.util.HashMap;
import java.util.List;

public class WinningDetails {
    private final List<Lotto> lottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private final HashMap<Integer,Integer> rank;
    private boolean bonusMatch;

    public WinningDetails(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.rank = new HashMap<>();
        initRank();
        checkWinningCount();
    }

    public HashMap<Integer,Integer> getRank(){
        return rank;
    }

    private void initRank(){
        for (int i = FIRST_RANK.getRank(); i <= FIFTH_RANK.getRank(); i++) {
            rank.put(i,0);
        }
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
        if(matchNumbers == FIFTH_RANK.getMatchNumbers() && !bonusMatch){
            rank.put(FIFTH_RANK.getRank(), rank.get(FIFTH_RANK.getRank())+1);
        }

        if(matchNumbers == FOURTH_RANK.getMatchNumbers() && !bonusMatch){
            rank.put(FOURTH_RANK.getRank(), rank.get(FOURTH_RANK.getRank())+1);
        }

        if(matchNumbers == THIRD_RANK.getMatchNumbers() && !bonusMatch){
            rank.put(THIRD_RANK.getRank(), rank.get(THIRD_RANK.getRank())+1);
        }

        if(matchNumbers == SECOND_RANK.getMatchNumbers() && bonusMatch){
            rank.put(SECOND_RANK.getRank(), rank.get(SECOND_RANK.getRank())+1);
        }

        if(matchNumbers == FIRST_RANK.getMatchNumbers()){
            rank.put(FIRST_RANK.getRank(), rank.get(FIRST_RANK.getRank())+1);
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
