package lotto.utils;

import lotto.domain.Result;

public class Utils {
    public static int parseIntValidate(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public static long getRateOfReturn() {
        return Result.FIRST.getRevenue() + Result.SECOND.getRevenue() + Result.THIRD.getRevenue()
                       + Result.FOURTH.getRevenue() + Result.FIFTH.getRevenue();
    }
}
