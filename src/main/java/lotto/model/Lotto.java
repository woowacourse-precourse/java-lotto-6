package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    // enum 으로 고칠 수 있으면 고쳐
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;
    public static final int NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);

        validateCount(sortedNumbers);
        hasDuplicateNumber(sortedNumbers);
        validRange(sortedNumbers);

        sortNumbers(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // 메서드 이름 고칠 수 있음녀 고쳐
    // 빈 리스트도 사이즈로 확인 바로 가능 굳이 메서드 안 만ㄷ르어도 됨
    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void hasDuplicateNumber(List<Integer> numbers) {
        Set<Integer> exceptDuplicateNumber = new HashSet<>(numbers);

        if (exceptDuplicateNumber.size() != numbers.size()) {
            throw new IllegalArgumentException("중복되는 번호가 있어서는 안됩니다.");
        }
    }

    private void validRange(List<Integer> numbers) {
        // stream 가능하면 바꿔
        for (int number : numbers) {
            if (!(number >= MIN_RANGE && number <= MAX_RANGE)) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto that = (Lotto) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
