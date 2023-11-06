package lotto.utill;

import Validate.ValidateException;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utii {
    private static final String COMMA_REGEX = ",";

    public static boolean isSameInt(Integer num_1, Integer num_2) {
        return num_2 == num_1;
    }

    public static List<Integer> InputNumbers() {
        List<Integer> results = null;
        String[] arr = null;
        String inputStringLine = Console.readLine().trim();

        ValidateException.includeString(inputStringLine);
        ValidateException.blankCheck(inputStringLine);
        ValidateException.includeBlank(inputStringLine);
        ValidateException.includeSpecialString(inputStringLine);
        ValidateException.commaStartAndEnd(inputStringLine);
        ValidateException.hasConsecutiveEmptyValues(inputStringLine);

        arr = makeArrSplitComma(inputStringLine);
        results = makeListFromArr(arr);

        return results;
    }

    public static Integer InputNumber() {
        String inputStringLine = Console.readLine().trim();

        ValidateException.blankCheck(inputStringLine);
        

        return Integer.valueOf(inputStringLine);
    }

    private static String[] makeArrSplitComma(String inputStringLine) {
        return inputStringLine.split(COMMA_REGEX);
    }

    private static List<Integer> makeListFromArr(String[] arr) {
        return Arrays.stream(arr)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
