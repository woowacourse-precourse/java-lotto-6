package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_LOTTO_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String SEPARATOR = ",";
    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";
    private static final String ERROR_INPUT_IS_NOT_NUMBER = "숫자만 입력 가능합니다.";
    private static final String ERROR_INVALID_INPUT = "올바른 형식으로 입력해 주세요.";

    private InputView() {
    }

    public static int inputLottoPurchaseMoney() {
        System.out.println(INPUT_LOTTO_PURCHASE_MONEY_MESSAGE);
        return getUserNumberInput();
    }

    public static List<Integer> inputLottoWinningNumber() {
        try {
            System.out.println(INPUT_LOTTO_WINNING_NUMBERS_MESSAGE);
            return getUserNumbersInput();
        } catch (RuntimeException runtimeException) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + ERROR_INVALID_INPUT);
        }
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return getUserNumberInput();
    }

    private static int getUserNumberInput() {
        String userInput = Console.readLine();
        validateUserNumberInput(userInput);
        return Integer.parseInt(userInput);
    }

    private static List<Integer> getUserNumbersInput() {
        String userInput = Console.readLine();
        List<String> winningNumber = Arrays.asList(userInput.split(SEPARATOR));

        return winningNumber.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private static void validateUserNumberInput(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + ERROR_INPUT_IS_NOT_NUMBER);
        }
    }
}
