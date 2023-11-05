package lotto.util;

import java.util.Arrays;
import java.util.List;

public class ListUtils {

    public List<Integer> stringToIntegerList(String inputString) {
        String[] splitString = inputString.split(",", -1);
        return Arrays.stream(splitString).map(string -> Integer.parseInt(string)).toList();
    }
}
