package lotto.ui;

import static lotto.global.ErrorMessage.INVALID_LOTTO_NUMBER_ERROR;
import static lotto.global.ErrorMessage.INVALID_LOTTO_SIZE_ERROR;
import static lotto.global.ErrorMessage.INVALID_NATURAL_NUMBER_ERROR;
import static lotto.global.ErrorMessage.INVALID_PRICE_UNIT_ERROR;
import static lotto.global.LottoInformation.LOTTO_BALLS_NUMBER;
import static lotto.global.LottoInformation.LOTTO_MAX_NUMBER;
import static lotto.global.LottoInformation.LOTTO_MIN_NUMBER;
import static lotto.global.LottoInformation.LOTTO_PRICE_UNIT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static final String COMMA_SEPARATOR = ",";
    private static final int ZERO = 0;

    public static int getPurchasePrice() {
        String userInput = Console.readLine();
        return validPurchasePrice(userInput);
    }

    private static int validPurchasePrice(String userInput) {
        checkInteger(userInput);
        int price = StringToInt(userInput);
        checkNaturalNumber(price);
        checkPurchaseAmount(price);
        return price;
    }

    private static void checkInteger(String userInput) {
        try {
            StringToInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NATURAL_NUMBER_ERROR.getMessage());
        }
    }

    private static void checkNaturalNumber(int price) {
        if (isSmallerOrSameThan(price, ZERO)) {
            throw new IllegalArgumentException(INVALID_NATURAL_NUMBER_ERROR.getMessage());
        }
    }

    private static void checkPurchaseAmount(int price) {
        if (!isDividedBy(price, LOTTO_PRICE_UNIT)) {
            throw new IllegalArgumentException(INVALID_PRICE_UNIT_ERROR.getMessage());
        }
    }

    private static boolean isDividedBy(int number, int pivot) {
        return number % pivot == ZERO;
    }

    public static List<Integer> getUserNumbers() {
        String userInput = Console.readLine();
        List<Integer> userNumbers = parseIntegers(userInput);
        validUserNumbers(userNumbers);
        return userNumbers;
    }

    private static List<Integer> parseIntegers(String userInput) {
        try {
            return Arrays.stream(userInput.split(COMMA_SEPARATOR))
                    .map(number -> Integer.parseInt(number.trim()))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NATURAL_NUMBER_ERROR.getMessage());
        }
    }

    private static void validUserNumbers(List<Integer> userNumbers) {
        checkNumberSize(userNumbers);
        for (Integer number : userNumbers) {
            checkNaturalNumber(number);
            checkInRange(number);
        }
    }

    private static void checkNumberSize(List<Integer> userNumbers) {
        if (userNumbers.size() != LOTTO_BALLS_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private static void checkInRange(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_ERROR.getMessage());
        }
    }

    private static boolean isOutOfRange(int number) {
        return isSmallerThan(number, LOTTO_MIN_NUMBER) || isBiggerThan(number, LOTTO_MAX_NUMBER);
    }

    private static boolean isBiggerThan(int number, int pivot) {
        return number > pivot;
    }

    private static boolean isSmallerThan(int number, int pivot) {
        return number < pivot;
    }

    private static boolean isSmallerOrSameThan(int number, int pivot) {
        return number <= pivot;
    }


    public static int getBonusNumber() {
        String userInput = Console.readLine();
        return validBonusNumber(userInput);
    }

    private static int validBonusNumber(String userInput) {
        checkInteger(userInput);
        int bonusNumber = StringToInt(userInput);
        checkInRange(bonusNumber);
        return bonusNumber;
    }

    private static int StringToInt(String userInput) {
        return Integer.parseInt(userInput);
    }
}
