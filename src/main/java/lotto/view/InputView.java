package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.utils.ErrorMessage;

public class InputView {
    private static final int BONUS_NUMBER_MIN_RANGE = 1;
    private static final int BONUS_NUMBER_MAX_RANGE = 45;
    private static final int WINNING_NUMBER_LENGTH = 6;
    private static final int WINNING_NUMBER_MIN_RANGE = 1;
    private static final int WINNING_NUMBER_MAX_RANGE = 45;

    private InputView() {
    }

    public static String userInput() {
        return Console.readLine();
    }

    public static int userInputParsedInt(String input) {
        return Integer.parseInt(input);
    }

    public static int inputUserPrice() {
        try {
            return userInputPrice();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputUserPrice();
        }
    }

    private static int userInputPrice() {
        try {
            String input = userInput();
            return userInputParsedInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.USER_INSERT_ONLY_NUMBER.getMessage());
        }
    }


    public static List<Integer> inputLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        try {
            String input = InputView.userInput();
            inputSplitWinningNumbers(input, numbers);
            return numbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLottoNumbers();
        }
    }

    private static void inputSplitWinningNumbers(String input, List<Integer> numbers) {
        String[] numberStrings = input.split(",");
        try {
            if (numberStrings.length != WINNING_NUMBER_LENGTH) {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_SIZE_ERROR.getMessage());
            }
            for (String s : numberStrings) {
                int winningNumber = Integer.parseInt(s);
                if (winningNumber < WINNING_NUMBER_MIN_RANGE || winningNumber > WINNING_NUMBER_MAX_RANGE) {
                    throw new IllegalArgumentException(ErrorMessage.USER_INSERT_WINNING_NUMBER_IN_RANGE.getMessage());
                }
                numbers.add(winningNumber);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.USER_INSERT_WINNING_NUMBER_ONLY_NUMBER.getMessage());
        }
    }

    public static int inputBonusNumber() {
        try {
            return userBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

    private static int userBonusNumber() {
        while (true) {
            try {
                String input = InputView.userInput();
                return bonusNumber(input);
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.USER_INSERT_BONUS_ONLY_NUMBER.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int bonusNumber(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < BONUS_NUMBER_MIN_RANGE || bonusNumber > BONUS_NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE_ERROR.getMessage());
        }
        return bonusNumber;
    }

}
