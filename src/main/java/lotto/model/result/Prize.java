package lotto.model.result;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Prize {
    NONE(0, 0, "낙첨"),
    FIFTH(3, 5000, "3개 일치 (5,000원) - %d개"),
    FOURTH(4, 50000, "4개 일치 (50,000원) - %d개"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - %d개"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - %d개");

    private final int count;
    private final int money;
    private final String message;

    Prize(int count, int money, String message) {
        this.count = count;
        this.money = money;
        this.message = message;
    }

    public static Prize valueOf(int count, boolean isBonus) {
        if (isSecond(count, isBonus)) {
            return SECOND;
        }
        return findPrizeByCount(count);
    }

    private static boolean isSecond(int count, boolean isBonus) {
        return count == SECOND.count && isBonus;
    }

    private static Prize findPrizeByCount(int count) {
        return Arrays.stream(Prize.values())
                .filter(rank -> rank.isMatch(count))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isMatch(int count) {
        return this.count == count;
    }

    public static List<Prize> getPrize() {
        return Arrays.stream(Prize.values())
                .filter(prize -> !prize.equals(NONE))
                .collect(Collectors.toList());
    }

    public int getMoney() {
        return money;
    }

    public String getFormatMessage(int value) {
        return String.format(message, value);
    }
}