package lotto.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputValidator {

    private static final String NOT_NUMBER = "숫자가 아닙니다.";
    private static final String OUT_OF_RANGE = "수의 범위 1 ~ 45를 벗어났습니다.";
    private static final String NOT_DIVISIBLE_BY_THOUSAND = "1,000으로 나누어 떨어지지 않습니다.";
    private static final String LESS_THAN_THOUSAND = "1,000보다 작습니다.";
    private static final String DUPLICATE_WINNING_NUMBERS = "당첨 번호에 중복된 번호가 존재합니다.";
    private static final String NOT_SIX_WINNING_NUMBERS = "당첨 번호가 6개가 아닙니다.";
    private static final String ALREADY_USED_WINNING_NUMBER = "이미 당첨 번호로 사용 중인 번호 입니다.";

    private static final int ZERO = 0;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int THOUSAND = 1000;

    public static void validatePurchaseAmount(String purchaseAmount) {
        validateIsNumber(purchaseAmount);

        validateLessThanThousand(purchaseAmount);
        validateDivisibilityByThousand(purchaseAmount);
    }

    public static void validateWinningNumbers(String undividedWinningNumbers) {
        String[] dividedWinningNumbers = undividedWinningNumbers.split(",");

        validateIsNumber(dividedWinningNumbers);
        validateNumberRange(dividedWinningNumbers);
        validateNumberOfWinningNumbers(dividedWinningNumbers);
        validateNoDuplicateWinningNumbers(dividedWinningNumbers);
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, String bonusNumber) {
        validateIsNumber(bonusNumber);

        validateNumberRange(bonusNumber);
        validateBonusNumberNotUsed(winningNumbers, bonusNumber);
    }

    private static void validateIsNumber(String beforeValidation) {
        for (int i = 0; i < beforeValidation.length(); i++) {
            if (!Character.isDigit(beforeValidation.charAt(i))) {
                throw new IllegalArgumentException(NOT_NUMBER);
            }
        }
    }

    private static void validateIsNumber(String[] beforeValidations) {
        for (String beforeValidation : beforeValidations) {
            validateIsNumber(beforeValidation);
        }
    }

    private static void validateNumberRange(String beforeValidation) {
        int number = Integer.parseInt(beforeValidation);
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }

    private static void validateNumberRange(String[] beforeValidations) {
        for (String beforeValidation : beforeValidations) {
            validateNumberRange(beforeValidation);
        }
    }

    private static void validateLessThanThousand(String beforeValidation) {
        int purchaseAmount = Integer.parseInt(beforeValidation);
        if (purchaseAmount < THOUSAND) {
            throw new IllegalArgumentException(LESS_THAN_THOUSAND);
        }
    }

    private static void validateDivisibilityByThousand(String beforeValidation) {
        int purchaseAmount = Integer.parseInt(beforeValidation);
        if (purchaseAmount % THOUSAND != ZERO) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_THOUSAND);
        }
    }

    private static void validateNumberOfWinningNumbers(String[] beforeValidations) {
        if (beforeValidations.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(NOT_SIX_WINNING_NUMBERS);
        }
    }

    private static void validateNoDuplicateWinningNumbers(String[] beforeValidations) {
        HashSet<String> distinct = new HashSet<>(Arrays.asList(beforeValidations));
        if (distinct.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBERS);
        }
    }

    private static void validateBonusNumberNotUsed(List<Integer> winningNumbers, String bonusNumber) {
        if (winningNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ALREADY_USED_WINNING_NUMBER);
        }
    }

}
