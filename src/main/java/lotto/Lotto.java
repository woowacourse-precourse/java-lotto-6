package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int LOTTOSIZE = 6;
    private static final int MIN_LOTTONUMBER = 1;
    private static final int MAX_LOTTONUMBER = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTOSIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨번호의 개수는 6개입니다");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 중복될 수 없습니다");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if(!numbers.stream().allMatch(number -> number >= MIN_LOTTONUMBER && number <= MAX_LOTTONUMBER)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호의 숫자는 1~45사이입니다");
        }
    }
}
