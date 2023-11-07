package model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import util.ErrorMessage;

public class InputValueValidation {

    public int validatePurchaseAmount(String inputValue) {
        isInputValueContainOnlyDigits(inputValue);
        int purchaseAmount = Integer.parseInt(inputValue);
        isPurchaseAmountOver1000(purchaseAmount);
        isPurchaseAmountAcceptOnlyUnitOf1000(purchaseAmount);

        return purchaseAmount;
    }

    private void isPurchaseAmountAcceptOnlyUnitOf1000(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_ACCEPT_ONLY_UNIT_OF_1000.getMessage());
        }
    }

    private void isPurchaseAmountOver1000(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_MUST_BE_OVER_1000.getMessage());
        }
    }

    private void isInputValueContainOnlyDigits(String inputValue) {
        if (!inputValue.matches("^\\d+$")) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_CAN_ONLY_NUMBER.getMessage());
        }
    }

    public List<Integer> validatePrizeNumber(String inputValue) {
        isInputValueContainOnlyDigitsAndComma(inputValue);
        List<Integer> prizeNumber = parseStrToList(inputValue);
        isPrizeNumberDuplicated(prizeNumber);
        isPrizeNumberHasCorrectSize(prizeNumber);

        return prizeNumber;
    }

    private void isPrizeNumberHasCorrectSize(List<Integer> prizeNumber) {
        if (prizeNumber.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.PRIZE_NUMBER_MUST_BE_SIX_DIGITS.getMessage());
        }
    }

    private void isPrizeNumberDuplicated(List<Integer> prizeNumber) {
        if (prizeNumber.size() != new HashSet<>(prizeNumber).size()) {
            throw new IllegalArgumentException(ErrorMessage.PRIZE_NUMBER_MUST_NOT_BE_DUPLICATED.getMessage());
        }
    }

    private List<Integer> parseStrToList(String inputValue) {
        List<Integer> prizeNumberTemp = Arrays.stream(inputValue.split(","))
                .map(s -> {
                    int number = Integer.parseInt(s);
                    isPrizeNumberContainExceededNumber(number);
                    return number;
                })
                .collect(Collectors.toList());
        return prizeNumberTemp;
    }

    private void isPrizeNumberContainExceededNumber(int number) {
        if (number > 45) {
            throw new IllegalArgumentException(ErrorMessage.PRIZE_NUMBER_MUST_BE_UNDER_45.getMessage());
        }
    }

    private void isInputValueContainOnlyDigitsAndComma(String inputValue) {
        if (!inputValue.matches("^\\d+(,\\d+)*$")) {
            throw new IllegalArgumentException(ErrorMessage.PRIZE_NUMBER_CAN_ONLY_NUMBER_AND_COMMA.getMessage());
        }
    }

    public int validateBonusNumber(List<Integer> prizeNumber, String inputValue) {
        isInputStrDigit(inputValue);
        int bonusNumber = Integer.parseInt(inputValue);
        isBonusNumberExceeded(bonusNumber);
        isBonusNumberIncludedPrizeNumber(prizeNumber, bonusNumber);

        return bonusNumber;
    }

    private void isBonusNumberIncludedPrizeNumber(List<Integer> prizeNumber, int bonusNumber) {
        if (prizeNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    ErrorMessage.BONUS_NUMBER_MUST_NOT_BE_DUPLICATED_WITH_PRIZE_NUMBER.getMessage());
        }
    }

    private void isBonusNumberExceeded(int bonusNumber) {
        if (bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_MUST_BE_UNDER_45.getMessage());
        }
    }

    private void isInputStrDigit(String inputValue) {
        if (!inputValue.matches("^\\d+$")) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_CAN_ONLY_NUMBER.getMessage());
        }
    }
}
