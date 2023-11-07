package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinningCriteria;

import java.util.List;

public class WinningStatisticsService {
    Integer first=0, second=0, third=0, fourth=0, fifth=0, totalReward=0;

    public Result calcScore(List<Lotto> lottos, List<Integer>winningNumbers, Integer bonusNumber){
        int hit;
        boolean bonusHit;

        for(Lotto lotto : lottos){
            bonusHit = matchWithBonusNumber(lotto, bonusNumber);
            hit = matchWithWinningNumbers(lotto, winningNumbers);
            check(hit, bonusHit);
        }
        return new Result(first, second, third, fourth, fifth, totalReward);
    }
    private int matchWithWinningNumbers(Lotto lotto, List<Integer> winningNumbers){
        List<Integer> numList = lotto.getNumbers();
        numList.retainAll(winningNumbers);
        return numList.size();
    }
    private boolean matchWithBonusNumber(Lotto lotto, Integer bonusNumber){
        return lotto.getNumbers().contains(bonusNumber);
    }
    private void check(int hit, boolean bonusHit){
        if(hit== 6){
            first++;
            totalReward+=WinningCriteria.FIRST.getReward();
            return;
        }
        if(hit == 5 && bonusHit){
            second++;
            totalReward+=WinningCriteria.SECOND.getReward();
            return;
        }
        if(hit == 5 || hit == 4 && bonusHit){
            third++;
            totalReward+=WinningCriteria.THIRD.getReward();
            return;
        }
        if(hit == 4 || hit == 3 && bonusHit){
            fourth++;
            totalReward+=WinningCriteria.FOURTH.getReward();
            return;
        }
        if(hit == 3 || hit == 2 && bonusHit){
            fifth++;
            totalReward+=WinningCriteria.FIFTH.getReward();
        }
    }
}
