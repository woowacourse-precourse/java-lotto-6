package lotto.validator;

import static lotto.message.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import lotto.exception.ParseIntException;
import lotto.exception.UserInputException;
import lotto.util.InputUtil;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateIsNumber(String input) {
        try {
            InputUtil.parseInt(input);
        } catch (NumberFormatException e) {
            throw new ParseIntException(e);
        }
    }

    public static void validateIsNumbers(List<String> strings) {
        for (String string : strings) {
            validateIsNumber(string);
        }
    }


    public static void validateIsMultiplesOf1000(int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            throw new UserInputException(INVALID_PURCHASE_AMOUNT_UNIT);
        }
    }

    public static void validateUniqueNumbers(List<Integer> winningNums) {
        if (winningNums.stream().distinct().toList().size() != winningNums.size()) {
            throw new UserInputException(INVALID_UNIQUE_FORMAT);
        }
    }
    public static void validateUniqueNumbers(List<Integer> winningNums, int validateNum) {
        if (winningNums.stream().anyMatch(num -> num.equals(validateNum))) {
            throw new UserInputException(INVALID_UNIQUE_FORMAT);
        }
    }

    public static void validateInLottoRange(List<Integer> winningNums) {
        if (winningNums.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new UserInputException(INVALID_WINNING_NUMS_VALUE);
        }
    }
    public static void validateInLottoRange(int num) {
        if (num < 1 || num > 45) {
            throw new UserInputException(INVALID_WINNING_NUMS_VALUE);
        }
    }

    public static void validateIsLottoSize(List<Integer> winningNums) {
        if (winningNums.size() != 6) {
            throw new UserInputException(INVALID_WINNING_NUMS_COUNT);
        }
    }
}
