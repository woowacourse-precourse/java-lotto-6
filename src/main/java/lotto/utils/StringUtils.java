package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.exceptions.InvalidNumberException;

public class StringUtils {
    public static int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
    }

    public static List<Integer> parseIntList(String s, String separator) {
        List<String> splited = Arrays.stream(s.split(separator, -1)).toList();
        List<Integer> ret = new ArrayList<>();
        try {
            for (var sp : splited) {
                ret.add(Integer.parseInt(sp));
            }
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
        return ret;
    }
}
