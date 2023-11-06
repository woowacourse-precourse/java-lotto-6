package lotto.model;

import static lotto.exception.ExceptionMessage.NUMBER_DUPLICATE_EXCEPTION;

import lotto.constants.LottoRule;
import java.util.List;
import java.util.stream.Stream;

public class GoalNumbers {

    private static final String NUMBER_SPLITTER = ",";

    private final List<LottoNumber> numbers;

    private GoalNumbers(final List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static GoalNumbers from(final String goalNumbersInput) {
        String[] splitNumbers = goalNumbersInput.split(NUMBER_SPLITTER);
        List<LottoNumber> numbers = Stream.of(splitNumbers)
                .map(LottoNumber::from)
                .toList();
        LottoRule.validateNumbersSize(numbers.size());
        validateIsNumbersNotDuplicate(numbers);

        return new GoalNumbers(numbers);
    }

    private static void validateIsNumbersNotDuplicate(final List<LottoNumber> numbers) {
        List<LottoNumber> uniqueNumbers = numbers.stream()
                .distinct()
                .toList();

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE_EXCEPTION.getMessage());
        }
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
