package lotto.validation;

import lotto.constant.ErrorMessage;
import lotto.constant.NumberUtil;
import lotto.domain.Lotto;

import java.util.*;
import java.util.stream.Collectors;

public class InputValidation {

    private final int minNumber = NumberUtil.MIN_NUMBER.getNumber();
    private final int startNumber = NumberUtil.START_NUMBER.getNumber();
    private final int endNumber = NumberUtil.END_NUMBER.getNumber();

    public int validatePurchaseAmount(String input) {
        validateInputIsNumeric(input);
        validateCheckRangeOfPurchaseAmountInput(input);
        int purchaseAmount = Integer.parseInt(input);
        validatePurchaseAmountIsPositive(purchaseAmount);
        validatePurchaseAmountOutOfRange(purchaseAmount);
        validatePurchaseAmountUnit(purchaseAmount);

        return purchaseAmount;
    }

    public List<Integer> validateWinnerNumbers(String input) {
        validateInputUseCorrectSeperator(input);
        validateWinnerNumbersNumeric(input);
        validateWinnerNumbersPositive(input);
        List<Integer> winnerNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validateWinnerNumbersOutOfRange(winnerNumbers);
        validateDuplicateWinnerNumbers(winnerNumbers);

        return winnerNumbers;
    }

    public int validateBonusNumber(String input) {
        validateInputIsNumeric(input);
        validateCheckRangeOfBonusNumberInput(input);
        int bonusNumber = Integer.parseInt(input);
        validateBonusNumberIsPositive(bonusNumber);
        validateBonusNumberOutOfRange(bonusNumber);

        return bonusNumber;
    }

    public void validateInputIsNumeric(String input) {
        if (!input.matches("[-+]?\\d*")) {
            throw new NumberFormatException(ErrorMessage
                    .INPUT_ONLY_NUMBERS_ERROR_MESSAGE
                    .getMessage());
        }
    }

    public void validateCheckRangeOfPurchaseAmountInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(ErrorMessage
                    .MAX_PURCHASE_AMOUNT_CONSTRAINT_ERROR_MESSAGE
                    .getMessage());
        }
    }

    public void validatePurchaseAmountOutOfRange(int purchaseAmount) {
        if (purchaseAmount > NumberUtil.MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage
                    .PURCHASE_AMOUNT_LIMIT_CONSTRAINT_ERROR_MESSAGE
                    .getMessage());
        }
    }

    public void validatePurchaseAmountIsPositive(int purchaseAmount) {
        if (purchaseAmount < minNumber) {
            throw new IllegalArgumentException(ErrorMessage
                    .POSITIVE_PURCHASE_AMOUNT_CONSTRAINT_ERROR_MESSAGE
                    .getMessage());
        }
    }

    public void validatePurchaseAmountUnit(int purchaseAmount) {
        if (purchaseAmount == 0 || purchaseAmount % NumberUtil.LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage
                    .PURCHASE_AMOUNT_UNITS_CONSTRAINT_ERROR_MESSAGE
                    .getMessage());
        }
    }

    public void validateInputIsNull(String input) {
        if (input == null || input.equals("")) {
            throw new NullPointerException(ErrorMessage
                    .NULL_OR_EMPTY_INPUT_ERROR_MESSAGE
                    .getMessage());
        }
    }

    public void validateInputUseCorrectSeperator(String input) {
        String deleteAllWords = input.replaceAll("[가-힣a-zA-Z0-9,-]", "");
        if (deleteAllWords.length() != 0) {
            throw new IllegalArgumentException(ErrorMessage
                    .CORRECT_SEPARATOR_INPUT_ERROR_MESSAGE
                    .getMessage());
        }
    }

    public void validateWinnerNumbersNumeric(String input) {
        String exceptSeperator = input.replaceAll("[,-]", "");
        validateInputIsNumeric(exceptSeperator);
    }

    public void validateCheckRangeOfWinnerNumberInput(String[] input) {
        try {
            for(String number : input) {
                Integer.parseInt(number);
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(ErrorMessage
                    .WINNING_NUMBER_OUT_OF_RANGE_MESSAGE
                    .getMessage());
        }
    }

    public void validateWinnerNumbersPositive(String input) {
        String[] winnerNumbers = input.split(",");

        validateCheckRangeOfWinnerNumberInput(winnerNumbers);
        for (String number : winnerNumbers) {
            if (Integer.parseInt(number) < minNumber) {
                throw new IllegalArgumentException(ErrorMessage
                        .POSITIVE_LOTTO_NUMBER_CONSTRAINT_MESSAGE
                        .getMessage());
            }
        }
    }

    public void validateWinnerNumbersOutOfRange(List<Integer> winnerNumbers) {
        for (Integer number : winnerNumbers) {
            if (number < startNumber || number > endNumber) {
                throw new IllegalArgumentException(ErrorMessage
                        .WINNING_NUMBER_OUT_OF_RANGE_MESSAGE
                        .getMessage());
            }
        }
    }

    public void validateDuplicateWinnerNumbers(List<Integer> winnerNumbers) {

        Set<Integer> numbers = new HashSet<>(winnerNumbers);

        if (winnerNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage
                    .DUPLICATE_NUMBER_CONSTRAINT_MESSAGE
                    .getMessage());
        }
    }

    public void validateCheckRangeOfBonusNumberInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(ErrorMessage
                    .BONUS_NUMBER_OUT_OF_RANGE_MESSAGE
                    .getMessage());
        }
    }

    public void validateBonusNumberIsPositive(int bonusNumber) {
        if (bonusNumber < minNumber) {
            throw new IllegalArgumentException(ErrorMessage
                    .POSITIVE_BONUS_NUMBER_CONSTRAINT_MESSAGE
                    .getMessage());
        }
    }

    public void validateBonusNumberOutOfRange(int bonusNumber) {
        if (bonusNumber < startNumber || bonusNumber > endNumber) {
            throw new IllegalArgumentException(ErrorMessage
                    .BONUS_NUMBER_OUT_OF_RANGE_MESSAGE
                    .getMessage());
        }
    }

    public void validateDuplicateBonusNumber(Lotto lotto, int bonusNumber) {
        List<Integer> winnerNumbers = lotto.getLottoNumbers();
        if (winnerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage
                    .DUPLICATE_WINNING_NUMBER_CONSTRAINT_MESSAGE
                    .getMessage());
        }
    }
}
