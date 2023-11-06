package lotto.view;

import static lotto.exception.LottoErrorCode.BLANK_INPUT;
import static lotto.exception.LottoErrorCode.NOT_INTEGER_INPUT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoException;

public class InputView {

    private final static String LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요";
    private final static String LOTTO_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static final String LOTTO_WINNING_NUMBER_DELIMITER = ",";

    public static int inputLottoPurchaseAmount() {
        System.out.println(LOTTO_PURCHASE_AMOUNT_MESSAGE);

        return getIntegerInput();
    }

    public static List<Integer> inputLottoWinningNumbers() {
        System.out.println(LOTTO_WINNING_NUMBER_MESSAGE);

        return getWinningNumbers();
    }

    private static List<Integer> getWinningNumbers() {
        return Arrays.stream(getInput().split(LOTTO_WINNING_NUMBER_DELIMITER))
            .map(InputView::convertToInteger)
            .toList();
    }

    public static int inputLottoBonusNumber() {
        System.out.println(LOTTO_BONUS_NUMBER_MESSAGE);

        return getIntegerInput();
    }

    private static int getIntegerInput() {
        return convertToInteger(getInput());
    }

    private static int convertToInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new LottoException(NOT_INTEGER_INPUT);
        }
    }

    private static String getInput() {
        final String input = Console.readLine().replaceAll(" ", "");
        validateNotBlank(input);
        return input;
    }

    private static void validateNotBlank(final String input) {
        if (input == null || input.isEmpty()) {
            throw new LottoException(BLANK_INPUT);
        }
    }

}