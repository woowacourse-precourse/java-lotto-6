package lotto.domain;

import java.util.*;

public class Lotto {

    private static final String NULL = "";
    private static final String SPACE = " ";
    private static final String COMMA = ",";
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int COUNT_LOTTO_NUMBER = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String winningNumberInput) {
        winningNumberInput = removeSpaces(winningNumberInput);
        List<String> winningNumbers = stringToList(winningNumberInput);
        validateInput(winningNumbers);
        validateDuplicate(winningNumbers);
        this.numbers = stringToInt(winningNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private String removeSpaces(String winningNumbers) {
        return winningNumbers.replace(SPACE, NULL);
    }

    private List stringToList(String inputNumbers) {
        return Arrays.asList(inputNumbers.split(COMMA));
    }

    private void validateInput(List<String> winningNumbersInput) {
        try {
            for(String winningNumberInput : winningNumbersInput) {
                checkNotNull(winningNumberInput);
                checkInteger(winningNumberInput);
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private void checkNotNull(String input) {
        if(input.equals(NULL) || input.isEmpty())
            ExceptionMessage.NULL_INPUT.throwException();
    }

    private void checkInteger(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                ExceptionMessage.INVALID_NUMBER.throwException();
            }
        }
    }

    private void validateDuplicate(List<String> winningNumbersInput) {
        try {
            checkDuplicates(winningNumbersInput);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private void checkDuplicates(List<String> inputs) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (String input : inputs) {
            if (uniqueNumbers.contains(input)) {
                ExceptionMessage.LOTTO_NUMBER_DUPLICATES.throwException();
            }
        }
    }

    private List<Integer> stringToInt(List<String> winningNumbersInput) {
        List<Integer> winningNumbers = new ArrayList<>();
        for(String winningNumberInput : winningNumbersInput) {
            int number = stringToInt(winningNumberInput);
            winningNumbers.add(number);
        }
        return winningNumbers;
    }

    private int stringToInt(String input) {
        return Integer.parseInt(input);
    }

    private void validate(List<Integer> numbers) {
        try {
            checkSixNumbers(numbers);
            checkInRange(numbers);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private void checkSixNumbers(List<Integer> numbers) {
        if (numbers.size() != COUNT_LOTTO_NUMBER) {
            ExceptionMessage.INVALID_LOTTO_WINNING_SIZE.throwException();
        }
    }

    private void checkInRange(List<Integer> numbers) {
        int minNumber = Collections.min(numbers);
        int maxNumber = Collections.max(numbers);
        if (minNumber < START_LOTTO_NUMBER || END_LOTTO_NUMBER < maxNumber) {
            ExceptionMessage.OUT_OF_RANGE.throwException();
        }
    }
}