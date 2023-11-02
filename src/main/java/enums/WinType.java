package enums;

import java.util.Arrays;

public enum WinType {

    NONE(0, false, 0),
    TRIPLE(3, false, 5000),
    QUADRA(4, false, 50000),
    PENTA(5, false, 1500000),
    PENTA_WITH_BONUS(5, true, 30000000),
    HEXA(6, false, 2000000000);


    private final Integer count;
    private final boolean bonus;
    private final long reward;

    WinType(Integer count, boolean bonus, long reward) {
        this.count = count;
        this.bonus = bonus;
        this.reward = reward;
    }

    public static WinType getByAttr(Integer count, boolean bonus) {
        return Arrays.stream(values())
                .filter(v -> v.count.equals(count))
                .filter(v -> v.bonus == bonus)
                .findAny()
                .orElse(NONE);
    }

    public long getReward() {
        return reward;
    }
}
