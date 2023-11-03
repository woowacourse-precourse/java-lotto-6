package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Util {

    // 메서드명 변경 필요
    public static String[] parse(String str) {
        return str.split(",");
    }

    public static List<Integer> stringToInt(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for (String number : args) {
            int intNum = Integer.parseInt(number);
            numbers.add(intNum);
        }
        return numbers;
    }
}
