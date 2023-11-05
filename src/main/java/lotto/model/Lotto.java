package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public String winningStatus(ArrayList<Integer> winningNumber, int bonusNumber) {
        int count = 0;
        boolean bonus = false;
        for (int number : numbers) {
            if (winningNumber.contains(number)) {
                count++;
            }
            if (number == bonusNumber) {
                bonus = true;
            }
        }
        return getRank(count, bonus);
    }

    private String getRank(int count, boolean bonus) {
        if (count == 6) {
            return "1등";
        }
        if (count == 5 && bonus) {
            return "2등";
        }
        if (count == 5 && !bonus) {
            return "3등";
        }
        if (count == 4) {
            return "4등";
        }
        if (count == 3) {
            return "5등";
        }
        return "꽝";
    }
}
