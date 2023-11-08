package lotto.model;

import java.util.List;

public class Lotto {

    private static final String LOTTO_NUMBER_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호가 중복됩니다.";
    private static final String INVALID_WINNING_NUMBERS_COUNT_EXCEPTION_MESSAGE = "[ERROR] 당첨 번호는 6개 입력해야 합니다.";
    private static final String WINNING_NUMBER_OUT_OF_RANGE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicate(numbers);
        validateNumberInRange(numbers);
        this.numbers = sortLottoNumber(numbers);
    }

    public int countNumber(final Lotto another) {
        return (int) another.numbers.stream()
                .filter(this::contains)
                .count();
    }

    public boolean contains(final int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validateLottoSize(final List<Integer> numbers) {
        if (isNotLottoSizeSix(numbers)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private void validateDuplicate(final List<Integer> numbers) {
        if (isNotLottoSizeSix(removeDuplicateLottoNumbers(numbers))) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private boolean isNotLottoSizeSix(final List<Integer> numbers) {
        return numbers.size() != LottoConstants.LOTTO_NUMBER_SIZE;
    }

    private List<Integer> removeDuplicateLottoNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .toList();
    }

    private void validateNumberInRange(final List<Integer> numbers) {
        if (hasInvalidNumbers(numbers)) {
            throw new IllegalArgumentException(WINNING_NUMBER_OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private boolean hasInvalidNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::isNotValidNumber);
    }

    private boolean isNotValidNumber(final int number) {
        return number < LottoConstants.START_NUMBER || number > LottoConstants.END_NUMBER;
    }

    private List<Integer> sortLottoNumber(final List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }
}
