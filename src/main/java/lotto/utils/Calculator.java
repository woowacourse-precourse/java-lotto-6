package lotto.utils;

import lotto.model.WinningLotto;

import java.util.List;

public class Calculator {

    public int calculatingRank(WinningLotto winningLotto, List<Integer> purchaseLotto){
        List<Integer> numbers = winningLotto.getNumbers();
        Integer bonusNumber = winningLotto.getBonusNumber();
        int rank = conversionRank(numbers,bonusNumber,purchaseLotto);
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

    private int conversionRank(List<Integer> numbers, Integer bonusNumber, List<Integer> purchaseLotto){
        int sameNumber = sameCount(numbers,purchaseLotto);
        if(sameNumber == 3){
            return 5;
        }
        if(sameNumber == 4){
            return 4;
        }
        if(sameNumber == 5){
            if(checkBonusNumber(bonusNumber,purchaseLotto)){
                return 2;
            }
            return 3;
        }
        if(sameNumber == 6){
            return 1;
        }
        return 6;
    }
}
