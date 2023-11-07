package lotto.utils;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static final String NUM_REGEX = "[0-9]+";
    private static final int BUY_AMOUNT_STD = 1000;
    private static final String INPUT_LOTTERY_NUMS = "([1-4][0-9]|[1-9],){5}([1-4][0-9]|[1-9])";
    private static final int LOTTERY_NUM_SIZE = 6;

    public static boolean isNumber (String input) {
        return input.matches(NUM_REGEX);
    }

    public static boolean validateBuyAmount(String buyAmount) {
        int amount = Integer.parseInt(buyAmount);
        if (amount < BUY_AMOUNT_STD || amount % BUY_AMOUNT_STD != 0) {
            return false;
        }
        return true;
    }

    public static boolean validateNumberAndSize(String inputLotteryNumbers) {
        return inputLotteryNumbers.matches(INPUT_LOTTERY_NUMS);
    }

    public static boolean isDuplicate(String[] result) {
        Set<String> set = new HashSet<>();
        for (String num : result) {
            set.add(num);
        }
        return set.size() != LOTTERY_NUM_SIZE;
    }
}
