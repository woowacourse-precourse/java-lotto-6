package lotto.domain;

import java.util.List;
import java.util.function.Predicate;

public class LottoWinCheck {
    // 로또 하나 몇개 당첨 되었는지

    private List<Integer> winningNumbers;
    private Integer bonusNum;

    public LottoWinCheck(List<Integer> winningNumbers, int bonusNum){
        this.winningNumbers = winningNumbers;
        this.bonusNum = bonusNum;
    }

    public List<Integer> getWinningNumbers(){
        return winningNumbers;
    }

    public Integer getBonusNum(){
        return bonusNum;
    }
    public int winningCheck(List<Integer> playerNumbers) {
        List<Integer> matchList = playerNumbers.stream().filter(o -> winningNumbers.stream()
                .anyMatch(Predicate.isEqual(o))).toList();
        return matchList.size();
    }

    public boolean bonusWinningCheck(){
        for(int number : winningNumbers){
            if(number == bonusNum){
                return true;
            }
        }
        return false;
    }
}
