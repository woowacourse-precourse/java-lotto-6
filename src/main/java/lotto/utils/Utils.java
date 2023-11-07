package lotto.utils;

import lotto.domain.result.Result;

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

    public static void plusCount(int number, boolean bonusByContains) {
        if (number == 3) {
            Result.FIFTH.plusCount();
        } else if (number == 4) {
            Result.FOURTH.plusCount();
        } else if (number == 5 && !bonusByContains) {
            Result.THIRD.plusCount();
        } else if (number == 5 && bonusByContains) {
            Result.SECOND.plusCount();
        } else if (number == 6) {
            Result.FIRST.plusCount();
        }
    }

    public static void showResult() {
        System.out.println(String.format("3개 일치 (5,000원) - %d개", Result.FIFTH.getCount()));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", Result.FOURTH.getCount()));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", Result.THIRD.getCount()));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", Result.SECOND.getCount()));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", Result.FIRST.getCount()));
    }
}
