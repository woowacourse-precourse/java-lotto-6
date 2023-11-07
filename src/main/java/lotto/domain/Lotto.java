package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int MAX_SIZE = 6;
    public static final int START_RANGE = 1;
    public static final int END_RANGE = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateRange(numbers);
        validateDuplication(numbers);
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개이어야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers){
        Set<Integer> nonDuplicatedNumbers = new HashSet<>(numbers);
        if (nonDuplicatedNumbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복돼서는 안됩니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number < START_RANGE || number > END_RANGE){
                throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이 여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        Integer[] arr = listToArray();
        return Arrays.toString(arr);
    }

    private Integer[] listToArray() {
        return numbers.toArray(new Integer[0]);
    }

    // TODO: 추가 기능 구현
}
