package lotto.model;

import java.util.List;

public class Lotto {

    private static final String LOTTO_NUMBER_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호가 중복됩니다.";

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicate(numbers);
        this.numbers = sortLottoNumber(numbers);
    }

    public boolean hasNumber(final int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validateLottoSize(final List<Integer> numbers) {
        if (isNotLottoSizeSix(numbers)) {
            throw new IllegalArgumentException();
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

    private List<Integer> sortLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }
}
