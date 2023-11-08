package lotto.view;

import static lotto.constant.ExceptionMessage.ONLY_NUMBER_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.utils.converter.Converter;
import lotto.utils.validator.InputValidator;

public class InputView {

    private static final String INPUT_BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private InputView() {
    }

    public static long getBuyAmountFromInput() {
        try {
            System.out.println(INPUT_BUY_AMOUNT_MESSAGE);
            String buyAmount = read();
            InputValidator.validateEmpty(buyAmount);
            return Long.parseLong(buyAmount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE);
        }
    }

    public static List<Integer> getWinningNumberFromInput() {
        try {
            System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
            String winningNumber = read();
            return Converter.convertStringToList(winningNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE);
        }
    }

    public static int getBonusNumberFromInput() {
        try {
            System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
            String bonusNumber = read();
            InputValidator.validateEmpty(bonusNumber);
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE);
        }
    }

    private static String read() {
        String userInput = Console.readLine().trim();
        System.out.println();
        return userInput;
    }
}
