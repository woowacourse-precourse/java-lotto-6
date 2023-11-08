package lotto;

import java.util.Comparator;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = this.sortAsc(numbers);
    }

    private void validate(List<Integer> numbers) {
        numbers.forEach(Lotto::validateNumberRange);
        validateLength(numbers);
        validateDuplicate(numbers);
    }

    public static void validateNumberRange(Integer number) {
        final Integer MIN = LottoConfig.LOTTO_NUMBER_MIN.getLottoConfig();
        final Integer MAX = LottoConfig.LOTTO_NUMBER_MAX.getLottoConfig();

        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getErrorMessage());
        }
    }

    private static void validateLength(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_LENGTH.getLottoConfig()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_LENGTH_INVALID.getErrorMessage());
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_DUPLICATE.getErrorMessage());
        }
    }

    private static List<Integer> sortAsc(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
