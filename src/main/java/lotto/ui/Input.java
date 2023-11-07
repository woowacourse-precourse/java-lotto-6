package lotto.ui;

import static lotto.global.ErrorMessage.INVALID_NATURAL_NUMBER_ERROR;
import static lotto.global.InputValidation.validBonusNumber;
import static lotto.global.InputValidation.validPurchasePrice;
import static lotto.global.InputValidation.validUserNumbers;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static final String COMMA_SEPARATOR = ",";

    public static int getPurchasePrice() {
        String userInput = Console.readLine();
        return validPurchasePrice(userInput);
    }

    public static List<Integer> getUserNumbers() {
        final String userInput = Console.readLine();
        List<Integer> userNumbers = parseIntegers(userInput);
        validUserNumbers(userNumbers);
        return userNumbers;
    }

    private static List<Integer> parseIntegers(final String userInput) {
        try {
            return Arrays.stream(userInput.split(COMMA_SEPARATOR))
                    .map(number -> Integer.parseInt(number.trim()))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NATURAL_NUMBER_ERROR.getMessage());
        }
    }

    public static int getBonusNumber() {
        final String userInput = Console.readLine();
        return validBonusNumber(userInput);
    }
}
