package lotto.utill;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utii {
    // TODO: 11/6/23 상수 관리
    private static final String COMMA_REGEX = ",";

    public static boolean isSameInt(Integer num_1, Integer num_2) {
        return num_2 == num_1;
    }


    public static Integer parseInteger(String inputStringLine) {
        return Integer.valueOf(inputStringLine);
    }

    public static String[] makeArrSplitComma(String inputStringLine) {
        return inputStringLine.split(COMMA_REGEX);
    }

    public static List<Integer> makeListFromArr(String[] arr) {
        return Arrays.stream(arr)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
