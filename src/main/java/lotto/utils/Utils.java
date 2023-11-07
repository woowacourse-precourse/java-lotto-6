package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validate.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    private static final int ONE = 1;
    private static final int ZERO = 0;
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final String NO_SPACE = "";

    public static List<Integer> randomUniqueNumberGenerate(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }

    public static List<Integer> sortListNaturalOrder(List<Integer> list) {
        List<Integer> orderedList = new ArrayList<>(list);
        Collections.sort(orderedList);
        return orderedList;
    }

    public static int[] stringToIntArray(String string) {
        return Arrays.stream(string.split(COMMA)).mapToInt(Integer::parseInt).toArray();
    }

    public static List<Integer> stringToIntegerList(String string) {
        string = string.replaceAll(SPACE, NO_SPACE);
        Validation.validateListStringToInteger(Arrays.asList(string.split(COMMA)));
        return Arrays.stream(stringToIntArray(string)).boxed().collect(Collectors.toList());
    }

    public static int stringToInteger(String string) {
        Validation.validateStringToInteger(string);
        return Integer.parseInt(string);
    }

    public static int countContainNumber(List<Integer> list, int number) {
        if (list.contains(number)) {
            return ONE;
        }
        return ZERO;
    }

    public static int countSameElements(List<Integer> list1, List<Integer> list2) {
        int count = ZERO;
        for (int number : list2) {
            count += countContainNumber(list1, number);
        }
        return count;
    }
}
