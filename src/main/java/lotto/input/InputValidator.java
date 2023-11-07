package lotto.input;

import java.util.Arrays;

import static lotto.GameConfig.*;

public class InputValidator {
    public static void validateBonusNumberInput(String input) {
        validateIsInteger(input);
        validateRangeOfNumber(Integer.parseInt(input));
    }

    public static void validatePurchaseMoneyInput(String input) {
        validateIsInteger(input);
        validatePurchaseMoneyUnit(input);
    }

    public static void validateWinningNumberInput(String input) {
        String[] separatedInput = input.split(LOTTO_NUMBER_INPUT_SEPARATOR);

        validateNumberOfBalls(separatedInput);
        Arrays.stream(separatedInput)
                .forEach(InputValidator::validateIsInteger);
        Arrays.stream(separatedInput)
                .forEach((numberString) -> {
                    int number = Integer.parseInt(numberString);
                    validateRangeOfNumber(number);
                });
        validateDuplication(separatedInput);
    }

    public static void validateDuplication(String[] separatedInput) {
        if (containsDuplication(separatedInput)) {
            throw new IllegalArgumentException("중복된 숫자가 존재할 수 없습니다.");
        }
    }

    public static void validateRangeOfNumber(int number) {
        if (hasInvalidRange(number)) {
            throw new IllegalArgumentException("1에서 45 사이의 정수를 입력해주십시오.");
        }
    }

    private static void validateNumberOfBalls(String[] separatedInput) {
        if (!hasValidNumberOfBalls(separatedInput)) {
            throw new IllegalArgumentException("','으로 구분된 여섯 개의 숫자를 입력해주십시오.");
        }
    }

    private static boolean containsDuplication(String[] separatedInput) {
        long distinctNumberCount = Arrays.stream(separatedInput)
                .distinct()
                .count();
        return distinctNumberCount != separatedInput.length;
    }

    private static boolean hasInvalidRange(int number) {
        return number < LOTTO_NUMBER_LOWER_BOUND || number > LOTTO_NUMBER_UPPER_BOUND;
    }

    private static boolean hasValidNumberOfBalls(String[] input) {
        return input.length == NUMBER_OF_LOTTO_NUMBERS;
    }

    private static void validatePurchaseMoneyUnit(String input) {
        if (!isMultipleOfUnit(Integer.parseInt(input))) {
            throw new IllegalArgumentException("최소 단위는 ~입니다.");
        }
    }

    private static boolean isMultipleOfUnit(int input) {
        return input % PURCHASE_MONEY_UNIT == 0;
    }

    private static void validateIsInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주십시오");
        }
    }

}
