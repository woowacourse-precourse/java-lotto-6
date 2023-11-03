package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Calculator {
    private int matchedThree = 0;

    public void calculatePrizeDescribe(Lotto lottoNumber, List<Integer> prizeNumber, int bonusNumber) {
        int matchedNumberCount = getMatchedNumberCount(lottoNumber, prizeNumber);

        if (matchedNumberCount == 3) {
            matchedThree += 1;
        }
    }

    private int getMatchedNumberCount(Lotto lottoNumber, List<Integer> prizeNumber) {
        Set<Integer> lottoNumberChangeToSet = new HashSet<>(lottoNumber.getNumbers());
        Set<Integer> prizeNumberChangeToSet = new HashSet<>(prizeNumber);

        lottoNumberChangeToSet.retainAll(prizeNumberChangeToSet);
        return lottoNumberChangeToSet.size();
    }

    public int getMatchedThree() {
        return matchedThree;
    }
}
