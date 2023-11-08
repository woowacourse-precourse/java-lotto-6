package lotto.condition;

public enum WinningConditions {
    FIRST_PLACE(6),
    SECOND_PLACE(5),
    THIRD_PLACE(5),
    FOURTH_PLACE(4),
    FIFTH_PLACE(3);

    private final int condition;

    WinningConditions(int condition) {
        this.condition = condition;
    }

    public int getCondition() {
        return condition;
    }
}
