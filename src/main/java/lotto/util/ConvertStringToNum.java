package lotto.util;

import java.util.Arrays;
import java.util.List;

public class ConvertStringToNum {
    public static List<Integer> toNum(String[] nums) {
        List<Integer> numericLIst = Arrays.stream(nums).filter(ConvertStringToNum::isNumeric).map(Integer::parseInt)
                .toList();
        return numericLIst;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str); // Integer로 변환을 시도
            return true;
        } catch (IllegalArgumentException illegalArgumentException) {
            return false;
        }
    }
}
