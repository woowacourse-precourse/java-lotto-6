package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String ERROR_MESSAGE ="[ERROR]";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        outOfRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "당첨 번호는 6개 입니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void duplicate(List<Integer> numbers) {
        Set<Integer> noDuplicateNumber = new HashSet<>(numbers);
        if(noDuplicateNumber.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "중복된 번호 입니다.");
        }
    }
    private void outOfRange(List<Integer> numbers) {
        for(int num : numbers) {
            if(num < 0 || num > 45) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
