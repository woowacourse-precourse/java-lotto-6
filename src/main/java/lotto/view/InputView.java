package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.util.Validation;

public class InputView {
    private static final String USER_INPUT_BUY_ACCOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String USER_INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String USER_INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int getUserInputForLottoBuyAccount() {
        System.out.println(USER_INPUT_BUY_ACCOUNT_MESSAGE);
        String userInput = Console.readLine();
        System.out.println();
        Validation.validateIsNotNumber(userInput);
        return convertStringToInt(userInput);
    }

    public static List<Integer> getUserInputForWinningNumbers() {
        System.out.println(USER_INPUT_WINNING_NUMBERS_MESSAGE);
        String userInput = Console.readLine();
        System.out.println();
        Validation.validateWinningNumbersWithRegex(userInput);
        return convertStringToList(userInput);
    }

    public static int getUserInputForBonusNumber() {
        System.out.println(USER_INPUT_BONUS_NUMBER_MESSAGE);
        String userInput = Console.readLine();
        System.out.println();
        Validation.validateIsNotNumber(userInput);
        return convertStringToInt(userInput);
    }

    private static List<Integer> convertStringToList(String userInput) {
        return Arrays.stream(userInput.split(",")).map(Integer::parseInt).toList();
    }

    private static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
