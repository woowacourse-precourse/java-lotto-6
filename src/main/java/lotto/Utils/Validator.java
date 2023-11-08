package lotto.Utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static List<String> newNumbers = new ArrayList<>();

    public static int validateNumber(String text) {
        var number = 0;
        while (true) {
            System.out.println(text);
            try {
                number = Integer.parseInt(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(SystemConstants.NOT_NUMBER);
                continue;
            }
            break;
        }

        return number;
    }

    public static String[] validateSixWinningNumbers(String text) {
        var winningNumbers = new String[0];
        while (true) {
            System.out.println("\n" + text);
            winningNumbers = createWinningNumbers();

            try {
                exceptionsOfWinningNumbers(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(SystemConstants.SIX_LOTTO_NUMBER);
                continue;
            }
            break;
        }
        return winningNumbers;
    }

    private static String[] createWinningNumbers() {
        var winningNumbersText = Console.readLine();
        return winningNumbersText.split(",", -1);
    }

    private static void exceptionsOfWinningNumbers(String[] winningNumbers) {
        exceptionLottoCount(winningNumbers);
        exceptionRange(winningNumbers);
        exceptionDuplicate(winningNumbers);
    }

    private static void exceptionLottoCount(String[] winningNumbers) {
        if (winningNumbers.length != SystemConstants.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private static void exceptionRange(String[] winningNumbers) {
        for (String number : winningNumbers) {
            var comparableNumber = Integer.parseInt(number);
            if (comparableNumber < 1 || comparableNumber > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void exceptionDuplicate(String[] winningNumbers) {
        Set<String> sortedNumbers = new HashSet<>(Arrays.stream(winningNumbers).toList());
        newNumbers = new ArrayList<>(sortedNumbers);
        if (newNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static int validateNotContainWinningNumbers(String text) {
        var number = 0;
        while (true) {
            number = validateNumber(text);
            try {
                exceptionsOfBonus(number);
            } catch (IllegalArgumentException e) {
                System.out.println(SystemConstants.NOT_IN_LOTTO_NUMBER);
                continue;
            }
            break;
        }

        return number;
    }

    private static void exceptionsOfBonus(int number) {
        exceptionDuplicatedByWinningNumbers(newNumbers, number);
        exceptionRangeByBonus(number);
    }

    private static void exceptionDuplicatedByWinningNumbers(List<String> winningNumbers, int number) {
        if (winningNumbers.contains(String.valueOf(number))) {
            throw new IllegalArgumentException();
        }
    }

    private static void exceptionRangeByBonus(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }
}
