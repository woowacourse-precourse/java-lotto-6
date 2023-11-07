package util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InputValueValidation {

    public int validatePurchaseAmount(String inputStr) {
        isInputValueContainOnlyDigits(inputStr);
        int purchaseAmount = Integer.parseInt(inputStr);
        isPurchaseAmountOver1000(purchaseAmount);
        isPurchaseAmountAcceptOnlyUnitOf1000(purchaseAmount);

        return purchaseAmount;
    }

    private void isPurchaseAmountAcceptOnlyUnitOf1000(int purchaseAmountTemp) {
        if (purchaseAmountTemp % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_ACCEPT_ONLY_UNIT_OF_1000.getMessage());
        }
    }

    private void isPurchaseAmountOver1000(int purchaseAmountTemp) {
        if (purchaseAmountTemp < 1000) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_MUST_BE_OVER_1000.getMessage());
        }
    }

    private void isInputValueContainOnlyDigits(String inputStr) {
        if (!inputStr.matches("^\\d+$")) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_CAN_ONLY_NUMBER.getMessage());
        }
    }

    public List<Integer> validatePrizeNumber(String inputStr) {
        isInputStrContainOnlyDigitsAndComma(inputStr);
        List<Integer> prizeNumber = parseStrToList(inputStr);
        isPrizeNumberDuplicated(prizeNumber);
        isPrizeNumberHasCorrectSize(prizeNumber);

        return prizeNumber;
    }

    private void isPrizeNumberHasCorrectSize(List<Integer> prizeNumberTemp) {
        if (prizeNumberTemp.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.PRIZE_NUMBER_MUST_BE_SIX_DIGITS.getMessage());
        }
    }

    private void isPrizeNumberDuplicated(List<Integer> prizeNumberTemp) {
        if (prizeNumberTemp.size() != new HashSet<>(prizeNumberTemp).size()) {
            throw new IllegalArgumentException(ErrorMessage.PRIZE_NUMBER_MUST_NOT_BE_DUPLICATED.getMessage());
        }
    }

    private List<Integer> parseStrToList(String inputStr) {
        List<Integer> prizeNumberTemp = Arrays.stream(inputStr.split(","))
                .map(s -> {
                    int num = Integer.parseInt(s);
                    isPrizeNumberContainExceededNumber(num);
                    return num;
                })
                .collect(Collectors.toList());
        return prizeNumberTemp;
    }

    private void isPrizeNumberContainExceededNumber(int num) {
        if (num > 45) {
            throw new IllegalArgumentException(ErrorMessage.PRIZE_NUMBER_MUST_BE_UNDER_45.getMessage());
        }
    }

    private void isInputStrContainOnlyDigitsAndComma(String inputStr) {
        if (!inputStr.matches("^\\d+(,\\d+)*$")) {
            throw new IllegalArgumentException(ErrorMessage.PRIZE_NUMBER_CAN_ONLY_NUMBER_AND_COMMA.getMessage());
        }
    }

    public int validateBonusNumber(List<Integer> prizeNumber, String inputStr) {
        isInputStrDigit(inputStr);
        int bonusNumber = Integer.parseInt(inputStr);
        isBonusNumberExceeded(bonusNumber);
        isBonusNumberIncludedPrizeNumber(prizeNumber, bonusNumber);

        return bonusNumber;
    }

    private void isBonusNumberIncludedPrizeNumber(List<Integer> prizeNumber, int bonusNumberTemp) {
        if (prizeNumber.contains(bonusNumberTemp)) {
            throw new IllegalArgumentException(
                    ErrorMessage.BONUS_NUMBER_MUST_NOT_BE_DUPLICATED_WITH_PRIZE_NUMBER.getMessage());
        }
    }

    private void isBonusNumberExceeded(int bonusNumberTemp) {
        if (bonusNumberTemp > 45) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_MUST_BE_UNDER_45.getMessage());
        }
    }

    private void isInputStrDigit(String inputStr) {
        if (!inputStr.matches("^\\d+$")) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_CAN_ONLY_NUMBER.getMessage());
        }
    }
}
