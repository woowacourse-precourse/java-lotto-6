package lotto.view;

import lotto.domain.WinningNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class InputWinningNumberView extends InputView {
    private static final String SEPARATOR = ",";
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 중복되지 않은 숫자여야 합니다.";
    private static final String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";

    public List<Integer> getWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);
        String input = inputValue();
        System.out.println();
        List<String> inputValue = parseWinningNumber(input);
        List<Integer> winningNumber = convertWinningNumber(inputValue);
        try {
            WinningNumber.validateWinningNumbers(winningNumber);
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
            int number = Integer.parseInt(input);
            numbers.add(number);
        }
        return numbers;
    }
}
