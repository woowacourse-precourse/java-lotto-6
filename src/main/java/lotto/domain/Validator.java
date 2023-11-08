package lotto.domain;

import java.util.*;

public class Validator {

    public static void validPurchaseAmount(String input) {
        validNumber(input);

        int purchaseAmount = Integer.parseInt(input);

        if (purchaseAmount % LottoConfiguration.UNIT != 0) {
            throw new IllegalArgumentException(Message.nonDivisibleUnitError);
        }

        if (purchaseAmount == 0) {
            throw new IllegalArgumentException(Message.moreAmountRequiredError);
        }
    }

    public static void validWinningNumbers(String input) {
        String[] splitInput = input.split(",");
        validWinningNumbersCount(splitInput);
        validAllNumbersInteger(splitInput);

        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < splitInput.length; i++) {
            int number = Integer.parseInt(splitInput[i]);
            validOutOfRangeNumber(number);

            if (hashSet.contains(number)) {
                throw new IllegalArgumentException(Message.duplicateNumberError);
            }
            hashSet.add(number);
        }
    }

    public static void validBonusNumber(String input) {
        validNumber(input);

    }

    private static void validNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.nonNumericInputError);
        }
    }

    private static void validWinningNumbersCount(String[] input) {
        if (input.length != LottoConfiguration.NUMBERS_SIZE) {
            throw new IllegalArgumentException(Message.incorrectCountError);
        }
    }

    private static void validAllNumbersInteger(String[] input) {
        for (int i = 0; i < input.length; i++) {
            validNumber(input[i]);
        }
    }

    private static void validOutOfRangeNumber(int number) {
        if (number >= LottoConfiguration.NUMBER_RANGE_START && number <= LottoConfiguration.NUMBER_RANGE_END) {
            throw new IllegalArgumentException(Message.outOfRangeError);
        }
    }
}
