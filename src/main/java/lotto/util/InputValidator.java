package lotto.util;

import lotto.constant.ConstantValue;

import java.util.List;

import static lotto.constant.ConstantValue.LOTTO_NUMBERS_SIZE;

public class InputValidator {
    public static Integer validatePurchaseAmount(String playerInput) {
        Integer purchaseAmount = validateIsInteger(playerInput);
        validateDivisible(purchaseAmount);
        validateIsPositive(purchaseAmount);
        return purchaseAmount;
    }

    public static Integer validateBonusNumber(String playerInput) {
        Integer bonusNumber = validateIsInteger(playerInput);
        validateIsPositive(bonusNumber);
        return bonusNumber;
    }

    private static Integer validateIsInteger(String playerInput){
        try {
            return Integer.parseInt(playerInput);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    private static void validateDivisible(Integer purchaseAmount){
        if(purchaseAmount % ConstantValue.LOTTO_PRICE != 0){
            throw new IllegalArgumentException();
        }
    }

    private static void validateIsPositive(Integer value){
        if (value <= 0){
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> validateWinningNumbers(String playerInput) {
        List<Integer> winningNumbers = validateIsIntegers(playerInput);
        validateIsPositive(winningNumbers);
        validateWinningNumbersSize(winningNumbers);
        return winningNumbers;
    }

    private static void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBERS_SIZE){
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> validateIsIntegers(String playerInput){
        try {
            List<String> splitPlayerInput = List.of(playerInput.split(","));
            return splitPlayerInput.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    private static void validateIsPositive(List<Integer> values){
        for (Integer value : values) {
            validateIsPositive(value);
        }
    }
}
