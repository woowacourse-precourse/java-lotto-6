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

    public static boolean isInteger(List<String> input) {
        return input.stream().allMatch(LottoUtil::isInteger);
    }
}
