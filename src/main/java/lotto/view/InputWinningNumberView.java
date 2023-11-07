package lotto.view;

import java.util.*;
import java.util.regex.Pattern;

public class InputWinningNumberView extends InputView {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final String BLANK = " ";
    private static final String SEPARATOR = ",";
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 중복되지 않은 숫자여야 합니다.";
    private static final String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final Pattern PATTERN = Pattern.compile("\\d+");

    public List<Integer> getWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);
        String input = inputValue();
        System.out.println();
        List<String> inputValue = parseWinningNumber(input);
        List<Integer> winningNumber = convertWinningNumber(inputValue);
        try {
            validateBlank(input);
            validateWinningNumber(winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE);
            return getWinningNumber();
        }
        return winningNumber;
    }

    private List<String> parseWinningNumber(String input) {
        return new ArrayList<>(Arrays.asList(input.split(SEPARATOR)));
    }

    private List<Integer> convertWinningNumber(List<String> inputValue) {
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputValue) {
            validateNumeric(input);
            int number = Integer.parseInt(input);
            numbers.add(number);
        }
        return numbers;
    }

    private void validateWinningNumber(List<Integer> numbers) {
        validateDuplicate(numbers);
        for (int number : numbers) {
            validateRangeNumber(number);
        }
    }

    private void validateNumeric(String input) {
        if (!PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRangeNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBlank(String input) {
        if (input.contains(BLANK)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        if (uniqueNumber.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
