package lotto;

import java.util.List;
import java.util.Set;

public class Lotto {

    static int lottoRangeFirstNum = 1;
    static int lottoRangeLastNum = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isWithinRange(numbers);
        hasDuplicateNum(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개입니다.");
        }
    }

    private void isWithinRange(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (!(num >= lottoRangeFirstNum && num <= lottoRangeLastNum)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1~45입니다.");
            }
        }
    }

    private void hasDuplicateNum(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
        }
    }
}
