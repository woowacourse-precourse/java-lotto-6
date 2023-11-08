package lotto.Validate;

import java.util.List;
import java.util.regex.Pattern;
import System.Constant;
import System.Exception;
import System.Phrase;

public class ValidateInput {

    public void validatePurchaseAmountPattern(String purchaseMoney) {
        boolean check = Pattern.matches("\\d+", purchaseMoney);

        if (!check) {
            System.out.println(Exception.LOTTO_PURCHASE_PATTERN_EXCEPTION.getMessage());
            throw new IllegalArgumentException(
                    Exception.LOTTO_PURCHASE_PATTERN_EXCEPTION.getMessage());
        }
    }

    public void validatePurchaseAmountUnit(String purchaseMoney) {
        boolean check = Integer.parseInt(purchaseMoney) % Constant.LOTTO_PRICE.getConstant() != 0;

        if (check) {
            System.out.println(Exception.LOTTO_PURCHASE_UNIT_EXCEPTION.getMessage());
            throw new IllegalArgumentException(
                    Exception.LOTTO_PURCHASE_UNIT_EXCEPTION.getMessage());
        }
    }

    public void validateWinningNumbersPattern(String winningNumbers) {
        boolean check = Pattern.matches(Phrase.RAFFLE_WINNING_NUMBER_PATTERN.getConstant(),
                winningNumbers);

        if (!check) {
            System.out.println(Exception.RAFFLE_WRONG_INPUT_EXCEPTION.getMessage());
            throw new IllegalArgumentException(Exception.RAFFLE_WRONG_INPUT_EXCEPTION.getMessage());
        }
    }

    public void validateWinningNumbersCheckInRange(List<Integer> winningNumberList) {
        boolean check = winningNumberList.stream().allMatch(
                x -> Constant.LOTTO_MIN_VALUE.getConstant() <= x
                        && Constant.LOTTO_MAX_VALUE.getConstant() >= x);

        if (!check) {
            throw new IllegalArgumentException(
                    Exception.RAFFLE_WRONG_NUMBER_EXCEPTION.getMessage());
        }
    }

    public void validateWinningNumbersHasDuplicate(List<Integer> winningNumberList) {
        boolean check = winningNumberList.size() != winningNumberList.stream().distinct().count();

        if (check) {
            System.out.println(Exception.RAFFLE_DUPLICATE_NUMBER_EXCEPTION.getMessage());
            throw new IllegalArgumentException(
                    Exception.RAFFLE_DUPLICATE_NUMBER_EXCEPTION.getMessage());
        }
    }

    public void validateBonusNumberPattern(String bonusNumber) {
        boolean check = Pattern.matches(Phrase.RAFFLE_BONUS_NUMBER_PATTERN.getConstant(),
                bonusNumber);

        if (!check) {
            System.out.println(Exception.RAFFLE_WRONG_INPUT_BONUS_NUMBER_EXCEPTION.getMessage());
            throw new IllegalArgumentException(
                    Exception.RAFFLE_WRONG_INPUT_BONUS_NUMBER_EXCEPTION.getMessage());
        }
    }

    public void validateWinningNumbersIsDuplicateBonusNumber(List<Integer> winninNumberList,
            String bonusNumber) {
        boolean check = winninNumberList.contains(Integer.parseInt(bonusNumber));

        if (check) {
            throw new IllegalArgumentException(
                    Exception.RAFFLE_DUPLICATE_BONUS_NUMBER_EXCEPTION.getMessage());
        }
    }
}
