package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class PrizeLottoValidator {
    private List<Integer> numbers;

    public void validateNumber(String numbers) {
        canSplitComma(numbers);

    }

    private void canSplitComma(String numbers) {
        if (Arrays.stream(numbers.split(",")).count() != 6) {
            throw new IllegalArgumentException("6개로 나누어지지 않는 문제");
        }
    }

    private void isCorrectNumber() {
        // 1 과 45 사이의 숫자인가

    }
}
