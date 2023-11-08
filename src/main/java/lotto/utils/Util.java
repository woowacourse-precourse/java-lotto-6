package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Util {

    public static int stringToIntger(String str) {
        return Integer.parseInt(str);
    }

    public static List<String> stringToStringList(String str) {
        String[] strs = str.split(",");
        return Arrays.asList(strs);
    }

    public static List<Integer> stringToSortedIntegerList(String str) {
        List<Integer> integers = new ArrayList<>();

        List<String> strings = stringToStringList(str);
        for (String string : strings) {
            int integer = stringToIntger(string);
            integers.add(integer);
        }

        sortList(integers);

        return integers;
    }

    public static void sortList(List<Integer> list) {
        Collections.sort(list);
    }

}
