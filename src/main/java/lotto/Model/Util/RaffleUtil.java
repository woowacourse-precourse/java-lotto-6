package lotto.Model.Util;

import System.Phrase;
import System.Constant;
import System.Exception;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RaffleUtil {

    public boolean validateWinningNumbers(String winningNumbers) {
        if (Pattern.matches(Phrase.RAFFLE_PATTERN.getConstant(), winningNumbers)) {
            return true;
        }
        throw new IllegalArgumentException(Exception.RAFFLE_WRONG_INPUT_EXCEPTION.getMessage());
    }

    public void checkInRange(List<Integer> winningNumberList) {
        boolean check = winningNumberList.stream().allMatch(
                x -> Constant.LOTTO_MIN_VALUE.getConstant() <= x
                        && Constant.LOTTO_MAX_VALUE.getConstant() >= x);

        if (!check) {
            throw new IllegalArgumentException(
                    Exception.RAFFLE_WRONG_NUMBER_EXCEPTION.getMessage());
        }
    }

    public void hasDuplicate(List<Integer> winningNumberList) {
        boolean check = winningNumberList.size() == winningNumberList.stream().distinct().count();

        if (!check) {
            throw new IllegalArgumentException(
                    Exception.RAFFLE_DUPLICATE_NUMBER_EXCEPTION.getMessage());
        }
    }

    public void isDuplicate(List<Integer> winninNumberList, int bonusNumber) {
        boolean check = winninNumberList.contains(bonusNumber);

        if (check) {
            throw new IllegalArgumentException(
                    Exception.RAFFLE_DUPLICATE_BONUS_NUMBER_EXCEPTION.getMessage());
        }
    }

    public List<Integer> parseWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(Phrase.RAFFLE_DELIMITER.getConstant()))
                .map(Integer::parseInt).collect(Collectors.toList());
    }

}
