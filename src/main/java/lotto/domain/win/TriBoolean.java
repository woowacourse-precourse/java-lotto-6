package lotto.domain.win;

import java.util.Arrays;

public enum TriBoolean {
    TRUE(2, true),
    WHATEVER(1, null),
    FALSE(0, false);

    private static final int EQUAL_DIFFERENCE_VALUE = 1;

    private final int value;
    private final Boolean bool;

    TriBoolean(int value, Boolean bool) {
        this.value = value;
        this.bool = bool;
    }

    public boolean equals(TriBoolean triState) {
        int difference = Math.abs(value - triState.value);
        return difference <= EQUAL_DIFFERENCE_VALUE;
    }

    public static TriBoolean from(Boolean bool) {
        return Arrays.stream(values())
                .filter(triState -> triState.bool == bool)
                .findFirst()
                .orElse(WHATEVER);
    }

}
