package lotto.domain.winningNumber;

import lotto.constants.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class WinningNumber {
    List<Integer> winningNumber;
    final String separator = ",";

    public WinningNumber(String input) {
        validate(input);
    }

    private void validate(String input) {
        validateFormat(input);
        validateEachContent(input);
        winningNumber = initWinningNumber(input);
    }

    private void validateFormat(String input) {
        try {
            input.split(separator);
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_FORMAT.getMessage());
        }
    }

    private void validateEachContent(String input) {
        for(String content : input.split(separator)) {
            WinningNumberValidator.validateNumericInput(content);
            WinningNumberValidator.validateValueInRange(content);
        }
    }

    private List<Integer> initWinningNumber(String input) {
        List<Integer> list = new ArrayList<>();
        for(String content : input.split(separator)) {
            list.add(Integer.parseInt(content));
        }
        return list;
    }

    public List<Integer> getWinningNumber() {
        return Collections.unmodifiableList(winningNumber);
    }
}