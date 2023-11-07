package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Utils {

    public static List<Integer> randomUniqueNumbers(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }

    public static int stringToInteger(String string) {
        return Integer.parseInt(string);
    }

    public static List<Integer> stringToIntegerList(String[] strings) {
        return Arrays.stream(strings)
                .map(Integer::parseInt) // Convert strings to integers
                .collect(Collectors.toList());
    }

    public static boolean countContainNumber(List<Integer> list, int number) {
        if (list.contains(number)) {
            return true;
        }
        return false;
    }

    public static String formatNumberWithCommas(long number) {
        String formattedNumber = String.format("%,d", number);
        return formattedNumber;
    }


    public static int countSameElements(List<Integer> list1, List<Integer> list2) {
        int count = 0;
        for (int number : list2) {
            count += countContainNum(list1, number);
        }
        return count;
    }

    private static int countContainNum(List<Integer> list, int number) {
        if (list.contains(number)) {
            return 1;
        }
        return 0;
    }


}
