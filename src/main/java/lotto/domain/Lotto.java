package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lotto.constant.ExceptionMessage;

public class Lotto {

    private static final Pattern LOTTO_REGEX_PATTERN = Pattern.compile("^(?:[1-9]|[1-3][0-9]|4[0-5])$");
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateDuplicateNumbers(numbers);
        validateLottoRegex(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private boolean isLengthSix(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private void validateLottoLength(List<Integer> numbers) {
        if (isLengthSix(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_LENGTH.toMessage());
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (isHaveDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.HAS_DUPLICATE_NUMBER.toMessage());
        }
    }

    private boolean isHaveDuplicateNumber(List<Integer> numbers) {
        Set<Integer> values = new HashSet<>(numbers);
        return values.size() < numbers.size();
    }

    private void validateLottoRegex(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!LOTTO_REGEX_PATTERN.matcher(number.toString()).matches()) {
                throw new IllegalArgumentException();
            }
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
