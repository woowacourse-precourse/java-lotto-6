package lotto.values;

public enum CorrectNumber {
    FIFTH_PLACE(3),
    FOURTH_PLACE(4),
    THIRD_PLACE(5),
    SECOND_PLACE(5),
    FIRST_PLACE(6);

    private final int value;

    CorrectNumber(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}