package util;

import domain.Lotto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import view.InputView;

public class UserInput {
    public static final int UNIT = 1000;
    public static final int MIN_PAYMENT = 1000;
    private static final String START_MESSAGE = "[ERROR]";
    private static final String WRONG_PAYMENT_MESSAGE = "%s %d 이상의 수를 %d 단위로 입력해주세요.";
    private static final String BLANK_ERROR_MESSAGE = "%s 아무 것도 입력되지 않았습니다.";
    private static final String WRONG_VALUE_MESSAGE = "%s 숫자가 아닌 값이 입력되었습니다.";
    private static final String DUPLICATE_MESSAGE = "%s 중복된 숫자가 입력되었습니다.";
    private static final String WRONG_LOTTO_NUMBER_MESSAGE = "%s %d 이상, %d 이하의 수를 입력해주세요.";


    public static long getUserPayment() {
        String userInput = InputView.setUserPayment();
        checkEmpty(userInput);
        long userPayment = checkLong(userInput);
        checkExceedsMinValue(userPayment);
        checkValidUnit(userPayment);
        return userPayment;
    }

    private static void checkEmpty(String userInput) {
        if (userInput.length() == 0) {
            throw new IllegalArgumentException(
                    String.format(BLANK_ERROR_MESSAGE, START_MESSAGE));
        }
    }

    private static long checkLong(String userInput) {
        try {
            return Long.parseLong(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    String.format(WRONG_VALUE_MESSAGE, START_MESSAGE));
        }
    }

    private static void checkExceedsMinValue(long userInput) {
        if (userInput < MIN_PAYMENT) {
            throw new IllegalArgumentException(
                    String.format(WRONG_PAYMENT_MESSAGE, START_MESSAGE, MIN_PAYMENT, UNIT));
        }
    }

    private static void checkValidUnit(long userInput) {
        if (userInput % UNIT != 0) {
            throw new IllegalArgumentException(
                    String.format(WRONG_PAYMENT_MESSAGE, START_MESSAGE, MIN_PAYMENT, UNIT));
        }
    }

    public static Lotto getWinningNumbers() {
        String userInput = InputView.setWinningNumbers();
        String[] splitInput = userInput.split(",");
        for (String input : splitInput) {
            checkEmpty(input);
        }
        List<Integer> winningNumbers = checkLong(splitInput);
        checkDuplicates(winningNumbers);
        for (int number : winningNumbers) {
            checkValidNumber(number);
        }
        return new Lotto(winningNumbers);
    }

    private static List<Integer> checkLong(String[] userInput) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < userInput.length; i++) {
            try {
                winningNumbers.add(Integer.parseInt(userInput[i]));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                        String.format(WRONG_VALUE_MESSAGE, START_MESSAGE));
            }
        }
        return winningNumbers;
    }

    private static void checkDuplicates(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(
                        String.format(DUPLICATE_MESSAGE, START_MESSAGE));
            }
        }
    }

    private static void checkValidNumber(int number) {
        if (number < Lotto.MIN_LOTTO_NUMBER || Lotto.MAX_LOTTO_NUMBER < number) {
            throw new IllegalArgumentException(
                    String.format(WRONG_LOTTO_NUMBER_MESSAGE,
                            START_MESSAGE, Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER));
        }
    }
}
