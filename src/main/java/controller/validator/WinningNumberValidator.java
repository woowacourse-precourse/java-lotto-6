package controller.validator;

import util.ConstantOfLotto;
import util.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberValidator {
    public List<Integer> checkWinningNumberValidation(String input) {
        List<String> parsedInput = parseInputByDelimiter(input);
        checkNumberOfWinningNumber(parsedInput);
        List<Integer> winningNumber = changeStringToInt(parsedInput);
        checkRangeOfWinningNumber(winningNumber);
        return winningNumber;
    }

    private void checkRangeOfWinningNumber(List<Integer> winningNumber) {
        for(Integer number : winningNumber) {
            if(number < ConstantOfLotto.MINIMUM_OF_LOTTO_NUMBER) {
                System.out.println(ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE.getErrorMessage());
                throw new IllegalArgumentException();
            }

            if(number > ConstantOfLotto.MAXIMUM_OF_LOTTO_NUMBER) {
                System.out.println(ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE.getErrorMessage());
                throw new IllegalArgumentException();
            }
        }
    }

    private List<Integer> changeStringToInt (List<String> parsedInput) {
        List<Integer> winningNumber = new ArrayList<>();
        for(String input : parsedInput) {
            try {
                int number= Integer.parseInt(input);
                winningNumber.add(number);
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.LOTTO_MUST_BE_COMPOSED_OF_NUMBER.getErrorMessage());
                throw new IllegalArgumentException();
            }
        }
        return winningNumber;
    }

    private void checkNumberOfWinningNumber(List<String> parsedInput) {
        if(parsedInput.size()!=6) {
            System.out.println(ErrorMessage.LOTTO_MUST_CONTAIN_SIX_NUMBERS.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    private List<String> parseInputByDelimiter(String input) {
        return List.of(input.split(ConstantOfLotto.DELIMITER));
    }
}
