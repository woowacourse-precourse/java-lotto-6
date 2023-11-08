package lotto.constant;

import java.math.BigDecimal;

public enum WinType {
    MATCHES_THREE("3개 일치", new BigDecimal(5000), 3, 0),
    MATCHES_FOUR("4개 일치", new BigDecimal(50000), 4, 0),
    MATCHES_FIVE("5개 일치", new BigDecimal(1500000), 5, 0),
    MATCHES_FIVE_BONUS("5개 일치, 보너스 볼 일치", new BigDecimal(30000000), 5, 1),
    MATCHES_SIX("6개 일치", new BigDecimal(2000000000), 6, 0);

    private final String winType;
    private final BigDecimal reward;
    private final int match;
    private final int bonus;

    WinType(String winType, BigDecimal reward, int match, int bonus) {
        this.winType = winType;
        this.reward = reward;
        this.match = match;
        this.bonus = bonus;
    }

    public static WinType get(int match, int bonus) throws IllegalArgumentException {
        for (WinType winType : WinType.values()) {
            if (winType.match == match && winType.bonus == bonus) {
                return winType;
            }
        }
        throw new IllegalArgumentException();
    }

    public String getName() {
        return winType;
    }

    public BigDecimal getReward() {
        return reward;
    }
}