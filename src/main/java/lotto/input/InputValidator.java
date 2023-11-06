package lotto.input;

import lotto.constant.Error;
import lotto.data.WinningNumbers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class InputValidator {
    public static void checkPurchaseAmount(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(Error.NOT_NUMBER);
        }

        if (Integer.parseInt(input) < 1000 || Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(Error.DO_NOT_DIVIDED_BY_1000);
        }
    }

    public static void checkWinningNumbers(String input) {
        Set<String> winningNumbers = new HashSet<>(Arrays.asList(input.split(",")));
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(Error.PLEASE_ENTER_A_UNDUPLICATED_NUMBER_OF_6);
        }

        Iterator<String> iterator = winningNumbers.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (!next.matches("\\d+") || !(Integer.parseInt(next) > 0) || !(Integer.parseInt(next) < 46)) {
                throw new IllegalArgumentException(Error.PLEASE_ENTER_ONLY_NUMBERS_FROM_1_TO_45);
            }
        }
    }

    public static void checkBonusNumber(String input, WinningNumbers winningNumbers) {
        if (!input.matches("\\d+") || !(Integer.parseInt(input) > 0) || !(Integer.parseInt(input) < 46)) {
            throw new IllegalArgumentException(Error.PLEASE_ENTER_ONLY_NUMBERS_FROM_1_TO_45);
        }
        if (winningNumbers.getWinningNumbers().contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException(Error.ALREADY_EXISTING_WINNING_NUMBER);
        }
    }
}
