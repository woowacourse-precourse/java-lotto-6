package lotto.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 문자열을 delimiter로 잘라 반환하는 클래스
 */
public class Splitter {
    public static List<String> splitString(String string, String delimiter) {
        String[] split = string.split(delimiter);

        return new ArrayList<>(Arrays.asList(split));
    }
}
