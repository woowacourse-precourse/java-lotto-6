package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class WinningNumber {
    List<Integer> winningNumber;

    public WinningNumber(String inputWinningNumber) {
        validateInputWinningNumber(inputWinningNumber);
    }

    private void validateInputWinningNumber(String inputValue) {
        String[] splitResult = validateFormat(inputValue);
        winningNumber = validateEachContent(splitResult);
    }

    private String[] validateFormat(String inputValue) {
        try {
            return inputValue.split(",");
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> validateEachContent(String[] splitResult) {
        List<Integer> result = new ArrayList<>();
        for(String content : splitResult) {
            validateOnlyNumber(content);
            result.add(validateBetweenMinNumberAndMaxNumber(content));
        }
        return result;
    }

    private void validateOnlyNumber(String content) {
        if(!content.matches("[0-9]+")) {
            throw new IllegalArgumentException();
        }
    }

    private int validateBetweenMinNumberAndMaxNumber(String content) {
        int result = Integer.parseInt(content);
        if(result < 0 || 45 < result) {
            throw new IllegalArgumentException();
        }
        return result;
    }
}
