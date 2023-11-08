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
        if (str.matches("\\d+")) {
            return true;
        }
        throw new IllegalArgumentException("올바른 숫자를 입력하세요");
        
    }
}
