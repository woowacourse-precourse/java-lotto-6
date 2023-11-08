package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.Errors;
import lotto.exception.FormatException;

public class InputView {
    private static final String MSG_ASKING_BUDGET = "구입금액을 입력해 주세요.";
    private static final String MSG_ASKING_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String MSG_ASKING_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static String getUserInput() {
        return Console.readLine().trim();
    }

    public static int printAskingBudget() {
        int budget;
        System.out.println(MSG_ASKING_BUDGET);
        while (true) {
            try {
                budget = Integer.parseInt(getUserInput());
                break;
            } catch (NumberFormatException e) {
                FormatException formatException = Errors.INVALID_NOT_NUMBER.getFormatException();
                System.out.println(formatException.getMessage());
            }
        }
        return budget;
    }

    public static List<Integer> printAskingWinningNumbers() {
        List<Integer> winningNumbers;
        System.out.println(MSG_ASKING_WINNING_NUMBERS);
        while (true) {
            try {
                winningNumbers = parseStringToList(getUserInput());
                break;
            } catch (NumberFormatException e) {
                FormatException formatException = Errors.INVALID_NOT_NUMBER.getFormatException();
                System.out.println(formatException.getMessage());
            }
        }
        return winningNumbers;
    }

    private static List<Integer> parseStringToList(String userInput) {
        return Arrays.stream(userInput.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int printAskingBonusNumber() {
        int bonusNumber;
        System.out.println(MSG_ASKING_BONUS_NUMBER);
        while (true) {
            try {
                bonusNumber = Integer.parseInt(getUserInput());
                break;
            } catch (NumberFormatException e) {
                FormatException formatException = Errors.INVALID_NOT_NUMBER.getFormatException();
                System.out.println(formatException.getMessage());
            }
        }
        return bonusNumber;
    }

    public static void close() {
        Console.close();
    }
}
