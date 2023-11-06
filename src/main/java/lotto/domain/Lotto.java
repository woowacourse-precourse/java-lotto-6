package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String NUMBER_RANGE_ERROR_MESSAGE = "숫자는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + "사이의 숫자여야합니다.";
    private static final String NUMBER_SIZE_ERROR_MESSAGE = "당첨 번호는 총 6개 입력 가능합니다.";
    private static final String NUMBER_OVERLAP_ERROR_MESSAGE = "중복된 숫자를 입력하셨습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOverlap(numbers);
        validateRange(numbers);

        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

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
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateOverlap(List<Integer> numbers) {
        Set<Integer> checkOverlap = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            checkOverlap.add(numbers.get(i));
        }
        if (checkOverlap.size() != 6) {
            throw new IllegalArgumentException(NUMBER_OVERLAP_ERROR_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < MIN_NUMBER || numbers.get(i) > MAX_NUMBER) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
            }
        }
    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(NUMBER_OVERLAP_ERROR_MESSAGE);
        }
    }

}
