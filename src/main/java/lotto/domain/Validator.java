package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Validator {

    private static final String nonNumericInputErrorMessage = "[ERROR] 숫자를 입력해주세요.";
    private static final String nonDivisibleUnitErrorMessage = "[ERROR] 1,000원 단위로 입력해주세요.";
    private static final String moreAmountRequiredErrorMessage = "[ERROR] 1,000원 이상을 입력해주세요.";
    private static final String incorrectCountErrorMessage = "[ERROR] 6개의 숫자를 입력해주세요.";
    private static final String outOfRangeErrorMessage = "[ERROR] 1~45 범위의 숫자만 입력해주세요.";
    private static final String duplicateNumberErrorMessage = "[ERROR] 중복되지 않는 숫자를 입력해주세요.";

    private static void validNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(nonNumericInputErrorMessage);
        }
    }

    public static void validPurchaseAmount(String input) {
        validNumber(input);

        int purchaseAmount = Integer.parseInt(input);

        if (purchaseAmount % LottoConfiguration.UNIT != 0) {
            throw new IllegalArgumentException(nonDivisibleUnitErrorMessage);
        }

        if (purchaseAmount == 0) {
            throw new IllegalArgumentException(moreAmountRequiredErrorMessage);
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
                throw new IllegalArgumentException(duplicateNumberErrorMessage);
            }
            hashSet.add(number);
        }
    }

    private static void validWinningNumbersCount(String[] input) {
        if (input.length != LottoConfiguration.NUMBERS_SIZE) {
            throw new IllegalArgumentException(incorrectCountErrorMessage);
        }
    }

    private static void validAllNumbersInteger(String[] input) {
        for (int i = 0; i < input.length; i++) {
            validNumber(input[i]);
        }
    }

    private static void validOutOfRangeNumber(int number) {
        if (number >= LottoConfiguration.NUMBER_RANGE_START && number <= LottoConfiguration.NUMBER_RANGE_END) {
            throw new IllegalArgumentException(outOfRangeErrorMessage);
        }
    }
}
