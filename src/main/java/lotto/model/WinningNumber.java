package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private static final int WINNING_NUMBER_MIN = 1;
    private static final int WINNING_NUMBER_MAX = 45;

    private final List<Integer> numbers = new ArrayList<>();

    public WinningNumber(List<Integer> numbers) {
        this.numbers.addAll(numbers);
        this.numbers.add(createBonusNumber());
    }

    private int createBonusNumber() {
        while (true) {
            int bonusNumber = Randoms.pickNumberInRange(WINNING_NUMBER_MIN, WINNING_NUMBER_MAX);
            if (!numbers.contains(bonusNumber)) {
                return bonusNumber;
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
