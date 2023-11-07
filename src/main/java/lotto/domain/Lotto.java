package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final static String errorMessageSize = "[ERROR] 로또 번호는 6개만 가능합니다.";
    private final static String errorMessageDuplicate = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private final static String errorMessageRange = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private final static int lottoSize = 6;
    private final static int startNumber = 1;
    private final static int endNumber = 45;

    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != lottoSize) {
            throw new IllegalArgumentException(errorMessageSize);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> notDuplicate = new HashSet<>(numbers);
        if (notDuplicate.size() != lottoSize) {
            throw new IllegalArgumentException(errorMessageDuplicate);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < startNumber || numbers.get(i) > endNumber) {
                throw new IllegalArgumentException(errorMessageRange);
            }
        }
    }
}
