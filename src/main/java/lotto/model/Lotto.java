package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    // 필드(인스턴스 변수) 추가 불가능!
    // 패키지 변경은 가능!

    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumbersRange(numbers);
        validateNumbersDuplication(numbers);
    }

    private void validateNumbersDuplication(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
        }
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 총 6개입니다.");
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (isOutOfLottoNumbersRange(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1에서 45 사이의 숫자입니다.");
            }
        }
    }

    private boolean isOutOfLottoNumbersRange(int number) {
        return number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER;
    }
}
