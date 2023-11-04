package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class DrawMachine {
    private List<Integer> winningNumbers;

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    private void winningNumbers() {
        this.winningNumbers = Randoms.pickUniqueNumbersInRange(Rule.MIN_NUMBER.value(), Rule.MAX_NUMBER.value(), Rule.DIGITS.value());
    }
}
