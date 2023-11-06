package utils;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Util {
    public static Set<Integer> stringToIntegerSet(String string) {
        return Arrays.stream(string.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
