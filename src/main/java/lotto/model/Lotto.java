package lotto.model;

import java.util.List;

public class Lotto {

    // 필드(인스턴스 변수) 추가 불가능!
    // 패키지 변경은 가능!

    private static final int WINNING_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersCount(numbers);
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 총 6개입니다.");
        }
    }
}
