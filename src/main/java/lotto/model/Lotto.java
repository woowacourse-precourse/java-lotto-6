package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constant.Constant.LOTTO_SIZE;
import static lotto.constant.Constant.MAX_LOTTO_NUMBER;
import static lotto.constant.Constant.MIN_LOTTO_NUMBER;
import static lotto.exception.ErrorInputException.ErrorMessage.LOTTO_NUMBER_CAN_NOT_BE_DUPLICATE;

import java.util.Collections;
import java.util.List;
import lotto.exception.ErrorInputException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDuplicate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createLotto() {
        List<Integer> pickedNumbers = pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
        return new Lotto(pickedNumbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void isDuplicate(List<Integer> numbers) {
        long countDistinct = numbers.stream().distinct().count();
        if (countDistinct < numbers.size()) {
            throw new ErrorInputException(LOTTO_NUMBER_CAN_NOT_BE_DUPLICATE);
        }
    }
}
