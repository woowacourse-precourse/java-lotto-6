package lotto.view.input;

import static lotto.view.input.InputErrorMessage.EMPTY_INPUT_ERROR;
import static lotto.view.input.InputErrorMessage.INVALID_DELIMITER_ERROR;
import static lotto.view.input.InputErrorMessage.INVALID_SIZE_ERROR;
import static lotto.view.input.InputErrorMessage.NOT_NUMBER_ERROR;
import static lotto.view.input.InputRegex.NUMBER_REGEX;
import static lotto.view.input.InputRegex.DELIMITER_REGEX;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputConsoleView implements InputView {

    @Override
    public String readOneNumber() {
        String input = Console.readLine();
        try {
                validateOneNumber(input);
        } catch (Exception e) {
                System.out.println(e.getMessage());
                readOneNumber();
        }
        return input;
    }

    @Override
    public String readWinningNumbers() {
        String input = Console.readLine();
        try {
            validateWinningNumbers(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            readWinningNumbers();
        }
        return input;
    }
    private void validateOneNumber(String input) {
        if(isInputEmpty(input)) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR.getMessage());
        }
        if(isNotNumber(input)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR.getMessage());
        }
    }

    private void validateWinningNumbers(String input) {
        if(isInputEmpty(input)) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR.getMessage());
        }
        if(isNotSeparateWithComma(input)) {
            throw new IllegalArgumentException(INVALID_DELIMITER_ERROR.getMessage());
        }
        validateEachElementOfWinningNumbers(input.split(DELIMITER_REGEX.getRegex()));
        if(isWinningNumbersSizeCorrect(input.split(DELIMITER_REGEX.getRegex()))){
            throw new IllegalArgumentException(INVALID_SIZE_ERROR.getMessage());
        }
    }

    private boolean isWinningNumbersSizeCorrect(String[] split) {
        return split.length != 6;
    }

    private void validateEachElementOfWinningNumbers(String[] elements) {
        for(String element : elements) {
            if(isNotNumber(element)) {
                throw new IllegalArgumentException(NOT_NUMBER_ERROR.getMessage());
            }
        }
    }

    private boolean isInputEmpty(String input) {
        return (input == null || input.isBlank());
    }

    private boolean isNotNumber(String input) {
        return !Pattern.matches(NUMBER_REGEX.getRegex(),input);
    }

    private boolean isNotSeparateWithComma(String input){
        return input.split(DELIMITER_REGEX.getRegex()).length == 1;
    }

}
