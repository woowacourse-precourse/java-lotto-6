package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String NOT_NUMBER_SIZE = "[ERROR] 당첨 번호는 6개만 입력 가능합니다.";
    private static final String NOT_NUMBER_OVERLAP = "[ERROR] 중복된 숫자를 입력했습니다.";
    private static final String NOT_NUMBER_RANGE = "[ERROR] 숫자는 " + MIN_NUMBER + "부터" + MAX_NUMBER + " 사이의 숫자여야 합니다."
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOverlap(numbers);
        validateRange(numbers);

        Collections.sort(numbers);
        this.numbers = numbers;
    }

    // 당첨번호 개수 세기
    public int countMatch(Lotto winningLotto) {
        return (int) numbers.stream().
                filter(winningLotto::containNumber).
                count();
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_NUMBER_SIZE);
        }
    }

    private void validateOverlap(List<Integer> numbers) {
        Set<Integer> overlapCheck = new HashSet<>();
        overlapCheck.addAll(numbers);

        if (overlapCheck.size() != 6) {
            throw new IllegalArgumentException(NOT_NUMBER_OVERLAP);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(NOT_NUMBER_RANGE);
            }
        }
    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(NOT_NUMBER_OVERLAP);
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
