package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.code.ErrorMessage;
import lotto.code.GameMessage;
import org.assertj.core.util.Strings;

import static lotto.utils.Constant.LOTTO_AMOUNT;

/**
 * InputUtils
 * <pre>
 * Describe here
 * </pre>
 *
 * @version 1.0,
 */
public class InputUtils {

    private InputUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static int getAmount() {
        String inputAmount = null;

        while (true) {
            PrintUtils.print(GameMessage.INPUT_AMOUNT);
            inputAmount = Console.readLine();
            boolean isValidAmount = false;
            try {
                isValidAmount = validAmount(inputAmount);
            } catch (IllegalArgumentException e) {
                PrintUtils.print(e.getMessage());
            }

            if (isValidAmount) {
                break;
            }

        }

        return Integer.parseInt(inputAmount);
    }

    private static boolean validAmount(String inputAmount) {
        if (Strings.isNullOrEmpty(inputAmount)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_DATA.getMessage());
        }

        int amount = 0;
        try {
            amount = Integer.parseInt(inputAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBERS.getMessage());
        }

        if (amount % LOTTO_AMOUNT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_UNIT_INPUT.getMessage());
        }

        return true;
    }
}
