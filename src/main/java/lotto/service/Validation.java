package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.constant.Constant.*;

public class Validation {

    public Integer validatePriceAndReturnNumber(String price) {
        Integer validatedPrice = null;
        try {
            validatedPrice = Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_ISSUE_LOTTO);
        }
        if (validatedPrice % 1000 != 0) {
            throw new IllegalArgumentException(EXCEPTION_ISSUE_LOTTO);
        }
        return validatedPrice/1000;
    }

    public List<Integer> validateWinning(String winning) {
        List<Integer> resultWinning = new ArrayList<>();
        String[] dividedWinning = winning.split(",");

        validateWinningLength(dividedWinning);
        validateWinningTypeAndAddNumber(resultWinning, dividedWinning);
        validateWinningDuplicated(dividedWinning);
        return resultWinning;
    }

    public Integer validateBonus(String bonus, List<Integer> winningNumbers) {
        try {
            Integer parseIntBonus = Integer.parseInt(bonus);
            validateBonusRange(parseIntBonus);
            validateBonusDuplicated(winningNumbers, parseIntBonus);
            return parseIntBonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_ISSUE_BONUS_RANGE);
        }
    }

    private static void validateWinningLength(String[] dividedWinning) {
        if (dividedWinning.length != 6) {
            throw new IllegalArgumentException(EXCEPTION_ISSUE_WINNING_NUMBER);
        }
    }

    private static void validateWinningTypeAndAddNumber(List<Integer> resultWinning, String[] dividedWinning) {
        for (String number : dividedWinning) {
            number = number.trim();
            validateWinningTypeAndAddNumberEach(resultWinning, number);
        }
    }

    private static void validateWinningTypeAndAddNumberEach(List<Integer> resultWinning, String number) {
        try {
            Integer parseIntNumber = Integer.parseInt(number);
            if (parseIntNumber <= 0 || parseIntNumber > 45) {
                throw new IllegalArgumentException(EXCEPTION_ISSUE_WINNING_RANGE);
            }
            resultWinning.add(parseIntNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_ISSUE_WINNING_RANGE);
        }
    }

    private static void validateWinningDuplicated(String[] dividedWinning) {
        String[] removeDuplicateWinning = Arrays.stream(dividedWinning).distinct().toArray(String[]::new);
        if (removeDuplicateWinning.length != dividedWinning.length) {
            throw new IllegalArgumentException(EXCEPTION_ISSUE_WINNING_DUPLICATED);
        }
    }


    private static void validateBonusRange(Integer parseIntBonus) {
        if (parseIntBonus <= 0 || parseIntBonus > 45) {
            throw new IllegalArgumentException(EXCEPTION_ISSUE_BONUS_RANGE);
        }
    }

    private static void validateBonusDuplicated(List<Integer> winningNumbers, Integer parseIntBonus) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber.equals(parseIntBonus)) {
                throw new IllegalArgumentException(EXCEPTION_ISSUE_BONUS_DUPLICATED);
            }
        }
    }
}
