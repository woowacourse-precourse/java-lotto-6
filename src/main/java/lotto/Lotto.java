package lotto;

import static lotto.Util.InputValidator.checkDistinctNumbers;
import static lotto.Util.ValidatorMessage.ERROR_MESSAGE;
import static lotto.Util.ValidatorMessage.NOT_A_SIX_DIGIT_ERROR;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_A_SIX_DIGIT_ERROR);
        }
        checkDistinctNumbers(numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
    }

    public String getLottoNumbers() {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
