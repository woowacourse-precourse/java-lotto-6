package lotto.model;

import static lotto.view.exception.InputException.NUMBER_DUPLICATE_EXCEPTION;
import static lotto.view.exception.InputException.NUMBER_FORMAT_EXCEPTION;
import static lotto.view.exception.InputException.UNVALID_GOAL_NUMBER;

import java.util.List;
import java.util.stream.Stream;

public class GoalNumbers {

    private static final String NUMBER_SPLITTER = ",";

    private final List<Integer> numbers;

    private GoalNumbers(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static GoalNumbers from(final String goalNumbersInput) {
        String[] splitNumbers = goalNumbersInput.split(NUMBER_SPLITTER);
        List<Integer> numbers = Stream.of(splitNumbers)
                .map(GoalNumbers::convertToNumber)
                .toList();
        LottoConstant.validateIsNumbersValidLottoLength(numbers);
        validateIsNumbersNotDuplicate(numbers);
        validateIsAllNumbersValid(numbers);

        return new GoalNumbers(numbers);
    }

    private static int convertToNumber(final String numberInput) {
        try {
            return Integer.parseInt(numberInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION.getMessage());
        }
    }

    private static void validateIsNumbersNotDuplicate(final List<Integer> numbers) {
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .toList();

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE_EXCEPTION.getMessage());
        }
    }

    private static void validateIsAllNumbersValid(final List<Integer> numbers) {
        int validNumbers = (int) numbers.stream()
                .filter(LottoConstant::isNumberValidLottoNumber)
                .count();

        if (validNumbers != numbers.size()) {
            throw new IllegalArgumentException(UNVALID_GOAL_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
