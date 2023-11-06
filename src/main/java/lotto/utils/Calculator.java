package lotto.utils;

import lotto.model.WinningLotto;

import java.util.List;

public class Calculator {
    public int calculatingRank(WinningLotto winningLotto, List<Integer> purchaseLotto){
        List<Integer> numbers = winningLotto.getNumbers();
        Integer bonusNumber = winningLotto.getBonusNumber();
        int rank = sameCount(numbers,purchaseLotto);
        if(checkBonusNumber(bonusNumber,purchaseLotto)){
            ++rank;
        }
        return rank;
    }

    public boolean checkBonusNumber(Integer bonusNumber, List<Integer> purchaseLotto){
        for(Integer element : purchaseLotto){
            if(element == bonusNumber){
                return true;
            }
        }
        return false;
    }

    public int sameCount(List<Integer> WinningLotto, List<Integer> PurchaseLotto){
        int count = 0;
        for(Integer element : PurchaseLotto){
            if(WinningLotto.contains(element)){
                count ++;
            }
        }
        return count;
    }
}
