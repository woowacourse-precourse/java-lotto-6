package enums;

import java.util.Arrays;

public enum WinType {

    NONE(0, false, 0, null),
    TRIPLE(3, false, 5000, StringEnums.TRIPLE),
    QUADRA(4, false, 50000, StringEnums.QUADRA),
    PENTA(5, false, 1500000, StringEnums.PENTA),
    PENTA_WITH_BONUS(5, true, 30000000, StringEnums.PENTA_WITH_BONUS),
    HEXA(6, false, 2000000000, StringEnums.HEXA);


    private final Integer count;
    private final boolean bonus;
    private final int reward;

    private final StringEnums stringEnum;

    WinType(Integer count, boolean bonus, int reward, StringEnums stringEnum) {
        this.count = count;
        this.bonus = bonus;
        this.reward = reward;
        this.stringEnum = stringEnum;
    }

    public static WinType getByAttr(Integer count, boolean bonus) {
        return Arrays.stream(values())
                .filter(v -> v.count.equals(count))
                .filter(v -> v.bonus == bonus)
                .findAny()
                .orElse(NONE);
    }

    public int getReward() {
        return reward;
    }

    public String getString() {
        return stringEnum.toString();
    }
}
