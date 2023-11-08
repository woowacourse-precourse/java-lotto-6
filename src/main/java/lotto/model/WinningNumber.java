package lotto.model;

import lotto.util.ErrorMessage;
import lotto.util.exception.CustomException;

import java.util.Arrays;
import java.util.List;

public class WinningNumber {
    private Lotto lotto;

    public WinningNumber(String input) {
        this.lotto = validate(input);
    }

    private Lotto validate(String input) {
        this.lotto = checkCorrectElement(checkCorrectNumberByDelimiter(input));
        return this.lotto;
    }

    private List<String> checkCorrectNumberByDelimiter(String input) {
        List<String> inputNumbers = Arrays.asList(input.split(","));
        if (inputNumbers.size() != 6) {
            throw new CustomException(ErrorMessage.WRONG_WINNING_NUMBER_COUNT);
        }
        return inputNumbers;
    }

    private Lotto checkCorrectElement(List<String> input) {
        try {
            List<Integer> list = input.stream()
                    .map(Integer::parseInt)
                    .toList();
            return new Lotto(list);
        } catch (NumberFormatException e) {
            throw new CustomException(ErrorMessage.WRONG_WINNING_NUMBER_FORMAT);
        }
    }

    public Lotto getLotto() {
        return lotto;
    }
}
