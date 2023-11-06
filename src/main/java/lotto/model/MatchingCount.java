package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchingCount {

    private final List<Integer> matchingCounts;

    public MatchingCount(){
        matchingCounts = new ArrayList<>(Collections.nCopies(Statistic.values().length,0));
    }

    public void updateMatchingCounts(Lotto lotto, Lotto winningNumbers, BonusNumber bonusNumber){
        int result = calculateMatchingResult(lotto, winningNumbers);
        if(result >= 3 && result <=6){
            int bonus = lotto.checkNumberInLotto(bonusNumber.getNumber());
            int index = calculateMatchingIndex(result, bonus);
            matchingCounts.set(index, matchingCounts.get(index)+1);
        }
    }

    private int calculateMatchingResult(Lotto lotto, Lotto winningNumbers){
        int result = 0;
        for(int number : winningNumbers.getSortedNumbers()){
            result += lotto.checkNumberInLotto(number);
        }
        return result;
    }

    private int calculateMatchingIndex(int result, int bonus){
        if(result == 5 && bonus == 1){
            return Statistic.BONUS.ordinal();
        }
        return Statistic.getRank(result).ordinal();
    }

    public List<Integer> getMatchingCounts(){
        return matchingCounts;
    }

}
