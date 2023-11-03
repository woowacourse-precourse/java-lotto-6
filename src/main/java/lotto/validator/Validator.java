package lotto.validator;

import java.util.Arrays;

public class Validator {

    public static void purchaseAmount(String inputPurchaseAmount) {
        if (isNotInteger(inputPurchaseAmount)) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }

        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);

        if (isPurchaseAmountZero(purchaseAmount)) {
            throw new IllegalArgumentException("최소 구매가격은 1000원 입니다.");
        }

        if (isNotDivisionForPrice(purchaseAmount)) {
            throw new IllegalArgumentException("1000원 단위로만 입력이 가능합니다.");
        }
    }

    public static void inputWinningNumbers(String inputWinningNumbers) {
        String[] winningNumbers = inputWinningNumbers.split(",");

        if (isInvalidWinningNumbersSize(winningNumbers)) {
            throw new IllegalArgumentException(",로 구분하여 총 6개의 숫자를 입력해주세요");
        }

        if (isNotIntegerWinningNumbers(winningNumbers)) {
            throw new IllegalArgumentException("당첨 번호에 정수가 아닌 값이 존재합니다.");
        }

        if (isNumberOutOfRange(winningNumbers)) {
            throw new IllegalArgumentException("1~45 범위에서 벗어난 숫자가 존재합니다.");
        }

        if (isDuplicateWinningNumbers(winningNumbers)) {
            throw new IllegalArgumentException("중복된 값이 존재합니다.");
        }
    }

    public static void inputBonusNumber(String inputBonusNumber, String[] winningNumbers) {
        if (isNotInteger(inputBonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 정수만 입력가능합니다.");
        }

        int bonusNumber = Integer.parseInt(inputBonusNumber);

        if (isInvalidRangeNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 1~45 범위의 정수만 입력가능합니다.");
        }

        if (isBonusNumberIncluded(inputBonusNumber, winningNumbers)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호에 포함되어 있습니다.");
        }
    }

    private static boolean isBonusNumberIncluded(String inputBonusNumber, String[] winningNumbers) {
        return Arrays.stream(winningNumbers).anyMatch(number -> number.equals(inputBonusNumber));
    }

    private static boolean isInvalidRangeNumber(int inputBonusNumber) {
        return !(1 <= inputBonusNumber && inputBonusNumber <= 45);
    }

    private static boolean isDuplicateWinningNumbers(String[] winningNumbers) {
        return Arrays.stream(winningNumbers).distinct().count() != winningNumbers.length;
    }

    private static boolean isNumberOutOfRange(String[] winningNumbers) {
        return Arrays.stream(winningNumbers)
                .mapToInt(Integer::parseInt)
                .anyMatch(number -> !(1 <= number && number <= 45));
    }

    private static boolean isNotIntegerWinningNumbers(String[] winningNumbers) {
         return Arrays.stream(winningNumbers).anyMatch(Validator::isNotInteger);
    }

    private static boolean isInvalidWinningNumbersSize(String[] winningNumbers) {
        return winningNumbers.length != 6;
    }


    private static boolean isPurchaseAmountZero(int purchaseAmount) {
        return purchaseAmount == 0;
    }

    private static boolean isNotDivisionForPrice(int purchaseAmount) {
        return ((double) purchaseAmount / 1000) != (purchaseAmount / 1000);
    }

    private static boolean isNotInteger(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
