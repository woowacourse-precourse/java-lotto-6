package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private static final int WINNING_NUMBER_SIZE = 7;
    private static final int WINNING_NUMBER_MIN = 1;
    private static final int WINNING_NUMBER_MAX = 45;

    private final List<Integer> numbers = new ArrayList<>();

    public WinningNumber() {
        initNumbers();
    }

    private void initNumbers() {
        numbers.addAll(Randoms.pickUniqueNumbersInRange(WINNING_NUMBER_MIN, WINNING_NUMBER_MAX, WINNING_NUMBER_SIZE));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
