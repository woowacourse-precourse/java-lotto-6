package lotto.controller;

import lotto.model.BonusNumber;

import java.util.List;

public class Comparison {
    public int compareLotto(List<Integer> lotto, List<Integer> randoms) {
        int sameCount = 0;
        for (int inputNum : randoms) {
            if (lotto.contains(inputNum)){
                sameCount += 1;
            }
        }
        return sameCount;
    }

    public Boolean compareBonus(List<Integer> numbers, int bonusNum) {
        if (numbers.contains(bonusNum)) {
            return true;
        }
        return false;
    }
}
