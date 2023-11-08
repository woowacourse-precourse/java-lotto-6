package lotto.model;

import static lotto.util.Message.ErrorMessage.DUPLICATION_EXCEPTION;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lotto.util.Constant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> nonDuplicationLotto = Set.copyOf(numbers);
        if (nonDuplicationLotto.size() != Constant.LOTTO_LENGTH) {
            throw new IllegalArgumentException(DUPLICATION_EXCEPTION.getMessage());
        }
    }

    public String winningStatus(ArrayList<Integer> winningNumber, int bonusNumber) {
        int count = 0;
        boolean bonus = false;
        for (int number : numbers) {
            if (winningNumber.contains(number)) {
                count++;
                continue;
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
        if (count == 5) {
            return validateSecondThird(bonus);
        }
        if (count == 4) {
            return "4등";
        }
        if (count == 3) {
            return "5등";
        }
        return "꽝";
    }

    public String getLottoValue() {
        return numbers.toString();
    }

    public String validateSecondThird(boolean bonus) {
        if (bonus) {
            return "2등";
        }
        return "3등";
    }

}
