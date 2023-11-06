package lotto.validation;

import lotto.constant.ErrorMessage;
import lotto.domain.Lotto;

import java.util.*;
import java.util.stream.Collectors;

public class InputValidation {
    ErrorMessage error;
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
            throw new NumberFormatException(error.INPUT_ONLY_NUMBERS_ERROR_MESSAGE.getMessage());
        }
    }

    public void validateCheckRangeOfPurchaseAmountInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(error.MAX_PURCHASE_AMOUNT_CONSTRAINT_ERROR_MESSAGE.getMessage());
        }
    }

    public void validatePurchaseAmountOutOfRange(int purchaseAmount) {
        if (purchaseAmount > 2100000000) {
            throw new IllegalArgumentException(error.PURCHASE_AMOUNT_LIMIT_CONSTRAINT_ERROR_MESSAGE.getMessage());
        }
    }

    public void validatePurchaseAmountIsPositive(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException(error.POSITIVE_PURCHASE_AMOUNT_CONSTRAINT_ERROR_MESSAGE.getMessage());
        }
    }

    public void validatePurchaseAmountUnit(int purchaseAmount) {
        if (purchaseAmount == 0 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(error.PURCHASE_AMOUNT_UNITS_CONSTRAINT_ERROR_MESSAGE.getMessage());
        }
    }

    public void validateInputIsNull(String input) {
        if (input == null || input.equals("")) {
            throw new NullPointerException(error.NULL_OR_EMPTY_INPUT_ERROR_MESSAGE.getMessage());
        }
    }

    public void validateInputUseCorrectSeperator(String input) {
        String deleteAllWords = input.replaceAll("[가-힣a-zA-Z0-9,-]", "");
        if (deleteAllWords.length() != 0) {
            throw new IllegalArgumentException(error.CORRECT_SEPARATOR_INPUT_ERROR_MESSAGE.getMessage());
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
            throw new IllegalArgumentException(error.WINNING_NUMBER_OUT_OF_RANGE_MESSAGE.getMessage());
        }
    }

    public void validateWinnerNumbersPositive(String input) {
        String[] winnerNumbers = input.split(",");

        validateCheckRangeOfWinnerNumberInput(winnerNumbers);
        for (String number : winnerNumbers) {
            if (Integer.parseInt(number) < 0) {
                throw new IllegalArgumentException(error.POSITIVE_LOTTO_NUMBER_CONSTRAINT_MESSAGE.getMessage());
            }
        }
    }

    public void validateWinnerNumbersOutOfRange(List<Integer> winnerNumbers) {
        for (Integer number : winnerNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(error.WINNING_NUMBER_OUT_OF_RANGE_MESSAGE.getMessage());
            }
        }
    }

    public void validateDuplicateWinnerNumbers(List<Integer> winnerNumbers) {
        Set<Integer> numbers = new HashSet<>();

        for (Integer number : winnerNumbers) {
            numbers.add(number);
        }

        if (winnerNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(error.DUPLICATE_NUMBER_CONSTRAINT_MESSAGE.getMessage());
        }
    }

    public void validateCheckRangeOfBonusNumberInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(error.BONUS_NUMBER_OUT_OF_RANGE_MESSAGE.getMessage());
        }
    }

    public void validateBonusNumberIsPositive(int bonusNumber) {
        if (bonusNumber < 0) {
            throw new IllegalArgumentException(error.POSITIVE_BONUS_NUMBER_CONSTRAINT_MESSAGE.getMessage());
        }
    }

    public void validateBonusNumberOutOfRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(error.BONUS_NUMBER_OUT_OF_RANGE_MESSAGE.getMessage());
        }
    }

    public void validateDuplicateBonusNumber(Lotto lotto, int bonusNumber) {
        List<Integer> winnerNumbers = lotto.getLottoNumbers();
        if (winnerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(error.DUPLICATE_WINNING_NUMBER_CONSTRAINT_MESSAGE.getMessage());
        }
    }
}
