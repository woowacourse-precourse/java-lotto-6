package utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import validator.Validator;

public class Utils {
    public static List<Integer> convertToIntegerList(String[] input) {
        Validator.validateWinningNumbersIsNumeric(input);
        return Arrays.stream(input)
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    public static String[] splitInputByComma(String input) {
        return input.split("＼＼s*,＼＼s*");
    }

    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
