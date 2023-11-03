package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class DrawMachine {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int DIGITS = 6;
    List<Integer> winningNumbers;

    public DrawMachine() {

    }

    private void setWinningNumbers() {
        this.winningNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, DIGITS);
    }
}
