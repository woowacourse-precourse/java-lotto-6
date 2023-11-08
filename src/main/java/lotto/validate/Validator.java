package lotto.validate;

import lotto.message.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.message.ErrorMessage.*;

public class Validator {
    public static void validatePurchaseMoney(String money) {
        if (!isNumeric(money)) {
            throw new IllegalArgumentException(NOT_NUMERIC_EXCEPTION.getMessage());
        }
        int purchaseMoney = Integer.parseInt(money);
        if (!isMultipleOf1000(purchaseMoney)) {
            throw new IllegalArgumentException(MULTIPLE_OF_THOUSAND_EXCEPTION.getMessage());
        }
        if (!isThousandOrMore(purchaseMoney)) {
            throw new IllegalArgumentException(THOUSAND_OR_MORE_EXCEPTION.getMessage());
        }
    }

    public static void validateWinningNumber(String numbers){
        if(hasBlank(numbers)){
            throw new IllegalArgumentException(HAS_BLANK_EXCEPTION.getMessage());
        }
        if(!isCommaSeparated(numbers)){
            throw new IllegalArgumentException(NOT_COMMA_SEPARATED_EXCEPTION.getMessage());
        }
        if(!isAllNumberic(numbers)){
            throw new IllegalArgumentException(NOT_ALL_NUMERIC_EXCEPTION.getMessage());
        }
        if(!isInRange(numbers)){
            throw new IllegalArgumentException(NOT_IN_RANGE_EXCEPTION.getMessage());
        }
        if(!areNumbersUnique(numbers)){
            throw new IllegalArgumentException(NOT_UNIQUE_EXCEPTION.getMessage());
        }
    }

    public static void validateBonusNumber(String number, List<Integer> winningNumbers){
        if(!isNumeric(number)){
            throw new IllegalArgumentException(NOT_NUMERIC_EXCEPTION.getMessage());
        }
        if(!isInRange(number)){
            throw new IllegalArgumentException(NOT_IN_RANGE_EXCEPTION.getMessage());
        }
        if(isBonusNumberInWinningNumbers(number, winningNumbers)){
            throw new IllegalArgumentException(NOT_UNIQUE_EXCEPTION.getMessage());
        }
    }

    public static boolean isBonusNumberInWinningNumbers(String bonusNumber, List<Integer> winningNumbers) {
        return winningNumbers.contains(Integer.parseInt(bonusNumber));
    }

    public static boolean hasBlank(String input) {
        return input.contains(" ");
    }

    public static boolean isCommaSeparated(String input) {
        return input.split(",").length == 6;
    }

    public static boolean isAllNumberic(String input){
        String[] split = input.split(",");
        return Arrays.stream(split).allMatch(s -> isNumeric(s));
    }

    public static boolean isInRange(String input){
        String[] split = input.split(",");
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .allMatch(number -> number >= 1 && number <= 45);
    }

    public static boolean areNumbersUnique(String input) {
        String[] split = input.split(",");

        Set<Integer> numberSet = Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        return numberSet.size() == split.length;
    }

    public static boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    public static boolean isMultipleOf1000(int money) {
        return money % 1000 == 0;
    }

    public static boolean isThousandOrMore(int number) {
        return number >= 1000;
    }
}
