package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class DrawMachine {
    List<Integer> winningNumbers;

    public DrawMachine() {

    }

    private void setWinningNumbers() {
        this.winningNumbers = Randoms.pickUniqueNumbersInRange(Rule.MIN_NUMBER.value(), Rule.MAX_NUMBER.value(), Rule.DIGITS.value());
    }
}
