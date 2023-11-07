package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        hasDuplicates(numbers);
        rangeCheck(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("6개의 숫자를 입력해야 합니다.");
        }
    }

    // TODO: 추가 기능 구현회

    // 당첨 번호끼리 중복되지 않는지 확인
    public void hasDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("중복되는 번호가 존재합니다.");
            }
        }
    }

    // 숫자 범위 체크
    public void rangeCheck(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException("1부터 45 사이의 숫자를 입력해주세요.");
            }
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
