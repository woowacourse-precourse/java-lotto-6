package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String SEPARATOR = ",";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String REQUEST_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_NOT_NUMBER = "숫자 형태의 값만 입력할 수 있습니다.";
    private static final String ERROR_NOT_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final Pattern PATTERN = Pattern.compile("\\d+");

    public String getInputMoney() {
        System.out.println(REQUEST_INPUT_MONEY);
        String input = Console.readLine();
        System.out.println();
        try {
            validateNumeric(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + ERROR_NOT_NUMBER);
            input = getInputMoney();
        }
        return input;
    }

    public List<Integer> getWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);
        String input = Console.readLine();
        System.out.println();
        List<String> inputValue = parseWinningNumber(input);
        List<Integer> winningNumber = convertWinningNumber(inputValue);
        try {
            validateWinningNumber(winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + ERROR_NOT_RANGE);
            return getWinningNumber();
        }
        return winningNumber;
    }

    public Integer getBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        String input = Console.readLine();
        System.out.println();
        try {
            validateNumeric(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + ERROR_NOT_NUMBER);
            return getBonusNumber();
        }
        return Integer.parseInt(input);
    }

    private List<String> parseWinningNumber(String input) {
        return new ArrayList<>(Arrays.asList(input.split(SEPARATOR)));
    }

    private List<Integer> convertWinningNumber(List<String> inputValue) {
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputValue) {
            int number = Integer.parseInt(input);
            numbers.add(number);
        }
        return numbers;
    }

    private void validateNumeric(String input) {
        if (!PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWinningNumber(List<Integer> numbers) {
        for (int number : numbers) {
            validateRangeNumber(number);
        }
    }

    private void validateRangeNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_NOT_RANGE);
        }
    }
}
