package lotto.exception;

import lotto.constant.ErrorText;

import java.util.List;

public class LottoNumberException {
    private static final int SIX_INPUT = 6;

    public void checkBlank(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorText.BLANK.getMessage());
        }
    }

    public void checkLottoNumber(String input) {
        int number = Integer.parseInt(input);

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorText.NOT_LOTTO_NUMBER.getMessage());
        }
    }

    public void checkEndWithNumber(String input) {
        int length = input.length();
        char lastNumber = input.charAt(length - 1);

        if (lastNumber < '0' || lastNumber > '9') {
            throw new IllegalArgumentException(ErrorText.END_WITH_NUMBER.getMessage());
        }
    }

    public void checkSixInputs(List<String> inputs) {
        if (inputs.size() != SIX_INPUT) {
            throw new IllegalArgumentException(ErrorText.INSUFFICIENT_LOTTO_NUMBER.getMessage());
        }
    }

    public void checkInteger(String number) {
        for (int index = 0; index < number.length(); index++) {
            if (number.charAt(index) < '0' || number.charAt(index) > '9') {
                throw new IllegalArgumentException(ErrorText.NOT_LOTTO_NUMBER.getMessage());
            }
        }
    }

    public void checkNumbers(List<String> inputs) {
        for (String input : inputs) {
            checkInteger(input.trim());
            checkLottoNumber(input.trim());
        }
    }

    private boolean isDuplicate(int currentIndex, List<String> numbers) {
        String currentNumber = numbers.get(currentIndex);

        for (int index = currentIndex + 1; index < numbers.size(); index++) {
            if (currentNumber.equals(numbers.get(index))) {
                return true;
            }
        }

        return false;
    }

    public void checkDuplicate(List<String> numbers) {
        for (int index = 0; index < numbers.size() - 1; index++) {
            if (isDuplicate(index, numbers)) {
                throw new IllegalArgumentException(ErrorText.DUPLICATE_WINNING_NUMBER.getMessage());
            }
        }
    }
}
