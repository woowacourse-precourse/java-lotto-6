package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public static int stringToIntger(String str) {
        return Integer.parseInt(str);
    }

    public static List<String> stringToStringList(String str) {
        String[] strs = str.split(",");
        return new ArrayList<>(Arrays.asList(strs));
    }

    public static List<Integer> stringToSortedIntegerList(String str) {
        List<Integer> integers = new ArrayList<>();

        List<String> strings = stringToStringList(str);
        for (String string : strings) {
            int integer = stringToIntger(string);
            integers.add(integer);
        }

        integers = sortList(integers);

        return integers;
    }

    public static List<Integer> sortList(List<Integer> list) {
        return list.stream().sorted().collect(Collectors.toList());
    }

}
