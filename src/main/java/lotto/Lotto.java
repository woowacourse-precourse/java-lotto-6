package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 갯수가 6개가 아닙니다.");
        }
    }

    private void duplicate(List<Integer> numbers) {
        HashSet<Integer> duplicateNumber = new HashSet<>();

        for (Integer number : numbers) {
            if (duplicateNumber.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 발생했습니다.");
            }

            duplicateNumber.add(number);
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> lottoNumber() {
        return numbers;
    }
}
