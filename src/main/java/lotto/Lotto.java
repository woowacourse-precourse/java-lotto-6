package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private static final String CHECK_SIZE_REQUEST_MESSAGE = "로또 번호는 총 6개여야 합니다.";
    private static final String CHECK_NUMBER_RANGE_REQUEST_MESSAGE = "로또 번호는 1~45 사이의 숫자여야 합니다.";
    private static final String CHECK_EACH_NUMBER_NOT_OVERLAP_REQUEST_MESSAGE = "로또 번호는 서로 중복되지 않아야 합니다.";
    private static final int LOTTO_SIZE = 6;
    private static final int TWO = 2;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNumberRange(numbers);
        validateEachNumberNotOverlap(numbers);

        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(CHECK_SIZE_REQUEST_MESSAGE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if ((number < LOTTO_MIN_NUMBER) || (number > LOTTO_MAX_NUMBER)) {
                throw new IllegalArgumentException(CHECK_NUMBER_RANGE_REQUEST_MESSAGE);
            }
        }
    }

    private void validateEachNumberNotOverlap(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(CHECK_EACH_NUMBER_NOT_OVERLAP_REQUEST_MESSAGE);
        }
    }

    public int countOverlappingNumbers(Lotto other) {
        Set<Integer> removedOverlappingNumbers = new HashSet<>();
        removedOverlappingNumbers.addAll(numbers);
        removedOverlappingNumbers.addAll(other.getNumbers());

        return (LOTTO_SIZE * TWO) - removedOverlappingNumbers.size();
    }

    public boolean isContainBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}