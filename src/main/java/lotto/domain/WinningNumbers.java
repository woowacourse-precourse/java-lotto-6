package lotto.domain;

import java.util.List;

public class WinningNumbers {

    public static final String INVALID_LOTTO_SIZE_MESSAGE = "당첨 번호는 숫자 " + Lotto.LOTTO_SIZE + "개를 입력해야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE_MESSAGE =
            "당첨 번호를 " + Lotto.MIN_LOTTO_NUMBER + " ~ " + Lotto.MAX_LOTTO_NUMBER + " 사이의 숫자로 입력해주세요.";
    public static final String DUPLICATE_NUMBERS_MESSAGE = "당첨 번호를 중복되지 않은 숫자로 입력해주세요.";

    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateWinningNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateWinningNumbers(final List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumbersInLottoRange(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateNumberSize(final List<Integer> numbers) {
        if (numbers.size() != Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_MESSAGE);
        }
    }

    private void validateNumbersInLottoRange(final List<Integer> numbers) {
        boolean anyMatch = numbers.stream()
                .anyMatch(number -> number < Lotto.MIN_LOTTO_NUMBER || number > Lotto.MAX_LOTTO_NUMBER);

        if (anyMatch) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE_MESSAGE);
        }
    }

    private void validateDuplicateNumbers(final List<Integer> numbers) {
        for (Integer number : numbers) {
            long count = numbers.stream().filter(num -> num.equals(number)).count();

            if (count > 1) {
                throw new IllegalArgumentException(DUPLICATE_NUMBERS_MESSAGE);
            }
        }
    }
}
