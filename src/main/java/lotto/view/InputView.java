package lotto.view;

import static lotto.exception.ErrorCode.BLANK_INPUT;
import static lotto.exception.ErrorCode.NOT_INTEGER_INPUT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.exception.InputException;

public class InputView {

    private final static String LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요";
    private final static String LOTTO_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static final String LOTTO_WINNING_NUMBER_DELIMITER = ",";

    public static int inputLottoPurchaseAmount() {
        while (true) {
            System.out.println(LOTTO_WINNING_NUMBER_MESSAGE);
            try {
                return getIntegerInput();
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> inputLottoWinningNumbers() {
        while (true) {
            System.out.println(LOTTO_WINNING_NUMBER_MESSAGE);
            try {
                return getWinningNumbers();
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> getWinningNumbers() {
        return Arrays.stream(getInput().split(LOTTO_WINNING_NUMBER_DELIMITER))
            .map(InputView::convertToInteger)
            .toList();
    }

    public static int inputLottoBonusNumber() {
        while (true) {
            System.out.println(LOTTO_BONUS_NUMBER_MESSAGE);
            try {
                return getIntegerInput();
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int getIntegerInput() {
        return convertToInteger(getInput());
    }

    private static int convertToInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new InputException(NOT_INTEGER_INPUT);
        }
    }

    private static String getInput() {
        final String input = Console.readLine().replaceAll(" ", "");
        validateNotBlank(input);
        return input;
    }

    private static void validateNotBlank(final String input) {
        if (input == null || input.isEmpty()) {
            throw new InputException(BLANK_INPUT);
        }
    }

}