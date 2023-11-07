package lotto.domain.winningNumber;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class WinningNumber {

    List<Integer> winningNumber;
    final String separator = ",";

    public WinningNumber(String input) {
        validate(input);
        winningNumber = initWinningNumber(input);
    }

    private void validate(String input) {
        validateFormat(input);
        validateLength(input);
        validateEachContent(input);
        validateDuplicateNumbers(input);
    }

    private void validateFormat(String input) {
        try {
            input.split(separator);
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_FORMAT.getMessage());
        }
    }

    private void validateLength(String input) {
        if (!isSameLengthAsLottoNumberCount(input)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_FORMAT.getMessage());
        }
    }

    private boolean isSameLengthAsLottoNumberCount(String input) {
        return input.split(separator).length == LottoRule.LOTTO_NUMBER_COUNT.getNumber();
    }

    private void validateEachContent(String input) {
        for (String content : input.split(separator)) {
            WinningNumberValidator.validateNumericInput(content);
            WinningNumberValidator.validateValueInRange(content);
        }
    }

    private void validateDuplicateNumbers(String input) {
        if (input.split(separator).length != Arrays.stream(input.split(separator)).distinct()
                .toArray().length) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE_NUMBER.getMessage());
        }
    }


    private List<Integer> initWinningNumber(String input) {
        List<Integer> list = new ArrayList<>();
        for (String content : input.split(separator)) {
            list.add(Integer.parseInt(content));
        }
        return list;
    }

    public List<Integer> getWinningNumber() {
        return Collections.unmodifiableList(winningNumber);
    }
}