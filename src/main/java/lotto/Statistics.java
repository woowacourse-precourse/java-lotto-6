package lotto;

public enum Statistics {
    THREE_MATCHES(3, 5000, "3개 일치 (5,000원) - %d개\n"),
    FOUR_MATCHES(4, 50000, "4개 일치 (50,000원) - %d개\n"),
    FIVE_MATCHES(5, 1500000, "5개 일치 (1,500,000원) - %d개\n"),
    BONUS_MATCHES(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    SIX_MATCHES(6, 2000000000, "6개 일치 (2,000,000,000원) - %d개\n"),
    NO_MATCH(0, 0, "당첨되지 않았습니다.");

    private final int value;
    private final int money;
    private final String message;

    Statistics(int value, int money, String message) {
        this.value = value;
        this.money = money;
        this.message = message;
    }

    public static Statistics of(int matchNumber, boolean bonusState) {
        if (bonusState) {
            if (matchNumber - 1 == BONUS_MATCHES.value) {
                return BONUS_MATCHES;
            }
            return findStatisticValue(matchNumber - 1);
        }
        return findStatisticValue(matchNumber);
    }

    private static Statistics findStatisticValue(int matchNumber) {
        for (Statistics stat : Statistics.values()) {
            if (stat != BONUS_MATCHES && stat.value == matchNumber) {
                return stat;
            }
        }
        return NO_MATCH;
    }

    public String getMessage() {
        return message;
    }

    public int getMoney() {
        return money;
    }

    public int getValue() {
        return value;
    }
}
