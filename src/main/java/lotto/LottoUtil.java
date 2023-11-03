package lotto;

import java.util.List;

public class LottoUtil {
    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isIntegers(List<String> input) {
        return input.stream().allMatch(LottoUtil::isInteger);
    }

    public static boolean isInRange(int check, int inclusiveMin, int inclusiveMax) {
        return inclusiveMin <= check && check <= inclusiveMax;
    }
}
