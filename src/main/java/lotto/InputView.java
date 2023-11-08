package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String MESSAGE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_INPUT_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";

    public int inputPurchaseAmount() throws IllegalArgumentException {
        System.out.println(MESSAGE_INPUT_PURCHASE_AMOUNT);
        return inputInteger();
    }

    public List<Integer> inputWinningNumbers() throws IllegalArgumentException {
        System.out.println(MESSAGE_INPUT_WINNING_NUMBERS);
        String read = Console.readLine();
        List<Integer> numbers = getNumbers(read);
        validateCount(numbers, 6);
        validateRange(numbers, 1, 45);
        return numbers;
    }

    public int inputBonusNumber() throws IllegalArgumentException {
        System.out.println(MESSAGE_INPUT_BONUS_NUMBER);
        return inputInteger(1, 45);
    }

    private int inputInteger() {
        String read = Console.readLine();
        validateIsNumber(read);
        return Integer.parseInt(read);
    }

    private int inputInteger(int startInclusive, int endInclusive) {
        int number = inputInteger();
        validateRange(number, startInclusive, endInclusive);
        return number;
    }

    private List<Integer> getNumbers(String s) {
        List<Integer> numbers = new ArrayList<>();
        for (String num : s.split(DELIMITER)) {
            validateIsNumber(num);
            numbers.add(Integer.parseInt(num));
        }
        return numbers;
    }

    private void validateIsNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다");
        }
    }

    private void validateCount(List<Integer> numbers, int count) {
        if (numbers.size() != count) {
            throw new IllegalArgumentException("입력한 숫자의 개수가 올바르지 않습니다");
        }
    }

    private void validateRange(List<Integer> numbers, int startInclusive, int endInclusive) {
        for (int number : numbers) {
            validateRange(number, startInclusive, endInclusive);
        }
    }

    private void validateRange(int number, int startInclusive, int endInclusive) {
        if (number < startInclusive || number > endInclusive) {
            throw new IllegalArgumentException("입력한 숫자의 범위가 올바르지 않습니다");
        }
    }
}
