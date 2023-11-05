package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.code.ErrorMessage;
import lotto.code.GameMessage;
import org.assertj.core.util.Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        String input = null;

        while (true) {
            PrintUtils.print(GameMessage.INPUT_AMOUNT);
            input = Console.readLine();
            boolean isValid = false;
            try {
                isValid = validAmount(input);
            } catch (IllegalArgumentException e) {
                PrintUtils.print(e.getMessage());
            }

            if (isValid) {
                break;
            }

        }

        return Integer.parseInt(input);
    }

    public static List<Integer> getWinnerNumbers() {
        String input = null;

        while (true) {
            PrintUtils.print(GameMessage.INPUT_WINNER_NUMBERS);
            input = Console.readLine();
            boolean isValid = false;
            try {
                isValid = validWinnerNumbers(input);
            } catch (IllegalArgumentException e) {
                PrintUtils.print(e.getMessage());
            }

            if (isValid) {
                break;
            }

        }

        return convertToWinnerNumbers(input);
    }

    private static boolean validAmount(String input) {
        if (Strings.isNullOrEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_DATA.getMessage());
        }

        int amount = 0;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBERS.getMessage());
        }

        if (amount % LOTTO_AMOUNT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_UNIT_INPUT.getMessage());
        }

        return true;
    }

    private static boolean validWinnerNumbers(String input) {
        if (Strings.isNullOrEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_DATA.getMessage());
        }

        List<Integer> winnerNumbers = convertToWinnerNumbers(input);
        if (winnerNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNER_NUMBERS_INPUT.getMessage());
        }

        Set<Integer> numbersSet = new HashSet<>(winnerNumbers);
        if (winnerNumbers.size() != numbersSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATION.getMessage());
        }

        long count = winnerNumbers.stream().filter(n -> n < 1 || n > 45).count();
        if (count > 0) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INVALID_NUMBER_RANGE.getMessage());
        }

        return true;
    }

    private static List<Integer> convertToWinnerNumbers(String input) {
        return Arrays.stream(input.split(",")).map(Integer::valueOf).toList();
    }
}
