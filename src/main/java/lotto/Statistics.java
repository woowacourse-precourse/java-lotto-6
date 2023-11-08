package lotto;

public enum Statistics {
    THREE_MATCHES(3, "3개 일치 (5,000원) - %d개"),
    FOUR_MATCHES(4, "4개 일치 (50,000원) - %d개"),
    FIVE_MATCHES(5, "5개 일치 (1,500,000원) - %d개"),
    BONUS_MATCHES(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_MATCHES(6, "6개 일치 (2,000,000,000원) - %d개"),
    NO_MATCH(0, "당첨되지 않았습니다.");

    private final int value;
    private final String message;

    Statistics(int value, String message) {
        this.value = value;
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

    public static Statistics findStatisticValue(int matchNumber) {
        for (Statistics stat : Statistics.values()) {
            if (stat != BONUS_MATCHES && stat.value == matchNumber) {
                return stat;
            }
        }
        return NO_MATCH;
    }
}
