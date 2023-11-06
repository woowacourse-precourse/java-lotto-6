package controller.validator;

import util.ConstantOfLotto;
import util.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class WinningNumberValidator {

    private final String REGEX = ",{2,}";

    public List<Integer> checkWinningNumberValidation(String input) {
        checkInputFormatIsCorrect(input);
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

    private void checkInputStartWithComma(String input) {
        if(input.charAt(0) == ',') {
            System.out.println(ErrorMessage.INCORRECT_WINNING_NUMBER_FORMAT.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    private void checkInputEndWithComma(String input) {
        if(input.charAt(input.length()-1) ==  ',') {
            System.out.println(ErrorMessage.INCORRECT_WINNING_NUMBER_FORMAT.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    private void findConsecutiveCommas(String input) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()) {
            System.out.println(ErrorMessage.INCORRECT_WINNING_NUMBER_FORMAT.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    private void checkInputFormatIsCorrect(String input) {
        findConsecutiveCommas(input);
        checkInputStartWithComma(input);
        checkInputEndWithComma(input);
    }
}
