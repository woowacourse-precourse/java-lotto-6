package lotto.controller;

import lotto.model.Cash;

import java.util.List;

public class Counting extends Comparison{
    public int getResult(List<Integer> lotto, int bonusNum, List<Integer> randomNums) {
        // 보너스 숫자가 같고, 5개 숫자가 같을 때
        if (compareBonus(randomNums, bonusNum)
                && compareLotto(lotto, randomNums) == 5) {
            return 7;
        }
        // 보너스 숫자가 다를 때
        return compareLotto(lotto, randomNums);
    }
}
