package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.utils.ErrorMessage;
import lotto.utils.LottoConstant;

public class InputView {
    public int getInteger() {
        String input = Console.readLine();
        validateNotNull(input);
        validateNotEmpty(input);
        validateParsedToInteger(input);
        return Integer.parseInt(input);
    }

    public List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        validateNotNull(input);
        validateNotEmpty(input);
        return Arrays.stream(input.split(LottoConstant.DELIMITER.get()))
                .peek(this::validateParsedToInteger)
                .map(Integer::parseInt)
                .toList();
    }

    private void validateNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_INPUT.getMessage());
        }
    }

    private void validateNotEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private void validateParsedToInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_INPUT.getMessage());
        }
    }
}
