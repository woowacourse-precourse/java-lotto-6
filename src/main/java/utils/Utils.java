package utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import validator.InputValidator;

public class Utils {
    public static List<Integer> convertToIntegerList(String[] input) {
        InputValidator.validateWinningNumbersIsNumeric(input);
        return Arrays.stream(input)
                     .map(Integer::parseInt)
                     .toList();
    }

    public static String[] splitInputByComma(String input) {
        return input.split("\\s*,\\s*");
    }

    public static List<Integer> generateRandomUniqueNumbers(
            int minValueInclusive, int maxValueInclusive, int selectionCount) {
        return Randoms.pickUniqueNumbersInRange(minValueInclusive, maxValueInclusive, selectionCount);
    }
}
