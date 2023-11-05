package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static constant.ErrorMessage.*;

public class ValidationUtil {
    public int validPurchaseLottoAmount(String lottoPurchaseAmount) {
        validPurchaseIntegerLottoAmount(lottoPurchaseAmount);
        return validPurchaseRemainLottoAmount(lottoPurchaseAmount);
    }

    public void validPurchaseIntegerLottoAmount(String lottoPurchaseAmount) {
        if (!lottoPurchaseAmount.matches("[0-9]+")) {
            throw new IllegalArgumentException(PURCHASE_TYPE);
        }
    }

    public int validPurchaseRemainLottoAmount(String lottoPurchaseAmount) {
        int validPurchaseAmount = Integer.parseInt(lottoPurchaseAmount);
        if (validPurchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_REMAINDER);
        }
        return validPurchaseAmount;
    }


    public String[] validWinningNumber(String input) {
        String[] validEachWinningNumber = input.split(",");
        validCountWinningNumber(validEachWinningNumber);
        validDuplicateWinningNumber(validEachWinningNumber);
        validRangeWinningNumber(validEachWinningNumber);
        return validEachWinningNumber;
    }

    private void validCountWinningNumber(String[] array) {
        if (array == null || array.length != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_SIX);
        }
    }

    private void validDuplicateWinningNumber(String[] array) {
        List<Integer> numbers = Arrays.stream(array)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE);
        }
    }

    private void validRangeWinningNumber(String[] array) {
        if (!Arrays.stream(array).mapToInt(Integer::parseInt).noneMatch(this::isValidRangeWinningNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE);
        }
    }

    private boolean isValidRangeWinningNumber(int number) {
        return number < 1 || number > 45;
    }

    public int validBonusNumber(String input) {
        int bonusNumber = validIntegerBonusNumber(input);
        validRangeBonusNumber(bonusNumber);
        return bonusNumber;
    }
    private int validIntegerBonusNumber(String input){
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(BONUS_TYPE);
        }
        return Integer.parseInt(input);
    }
    private void validRangeBonusNumber(int input){
        if(input < 1 || input > 45){
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE);
        }
    }
}

