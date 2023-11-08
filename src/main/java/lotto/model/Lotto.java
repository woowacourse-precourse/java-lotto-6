package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constant.Constant.*;
import static lotto.constant.ErrorMessage.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public static Lotto generate() {
        return new Lotto(
                pickUniqueNumbersInRange(
                        LOTTO_MIN_VALUE,
                        LOTTO_MAX_VALUE,
                        MAX_NUMBER_SIZE
                )
        );
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static class Validator {
        private static void validate(List<Integer> numbers) {
            checkValidNumberSize(numbers);
            checkNumberDuplicate(numbers);
            checkNumberInRange(numbers);
        }

        public static void checkValidNumberSize(List<Integer> numbers) {
            if (numbers.size() != MAX_NUMBER_SIZE) {
                throw new IllegalArgumentException(INVALID_NUMBER_SIZE.getMessage());
            }
        }

        public static void checkNumberDuplicate(List<Integer> numbers) {
            if (numbers.stream().distinct().count() != MAX_NUMBER_SIZE) {
                throw new IllegalArgumentException(NUMBER_DUPLICATE.getMessage());
            }
        }

        public static void checkNumberInRange(List<Integer> numbers) {
            if (numbers.stream()
                    .filter(n -> LOTTO_MIN_VALUE <= n && n <= LOTTO_MAX_VALUE)
                    .count() != MAX_NUMBER_SIZE) {
                throw new IllegalArgumentException(NUMBER_OUT_RANGE.getMessage());
            }
        }
    }
}
