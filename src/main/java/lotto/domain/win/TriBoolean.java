package lotto.domain.win;

import java.util.Arrays;

public enum TriBoolean {
    TRUE("참", 2, true),
    WHATEVER("상관없음", 1, null),
    FALSE("거짓", 0, false);

    private static final int EQUAL_DIFFERENCE_VALUE = 1;

    private final String description;
    private final int value;
    private final Boolean bool;

    TriBoolean(String description, int value, Boolean bool) {
        this.description = description;
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
