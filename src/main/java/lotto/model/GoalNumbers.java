package lotto.model;

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
                .filter(LottoConstant::isNumberValidLottoNumber)
                .distinct()
                .toList();
        LottoConstant.validateIsNumbersValidLottoLength(numbers);

        return new GoalNumbers(numbers);
    }

    private static int convertToNumber(final String numberInput) {
        try {
            return Integer.parseInt(numberInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
