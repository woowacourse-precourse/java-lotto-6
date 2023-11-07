package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrizeLotto {
    private final List<Integer> prizeNumbers;

    private final int bonusNum;

    public int getBonusNum() {
        return bonusNum;
    }

    public List<Integer> getPrizeNumbers() {
        return prizeNumbers;
    }

    public PrizeLotto(List<Integer> numbers, int bonusNum) {
        this.prizeNumbers = numbers;
        this.bonusNum = bonusNum;
    }


}
