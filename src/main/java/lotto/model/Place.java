package lotto.model;

public enum Place {

    NO_PLACE(0),
    FIRST_PLACE(1),
    SECOND_PLACE(2),
    THIRD_PLACE(3),
    FOURTH_PLACE(4),
    FIFTH_PLACE(5);

    private final int value;
    Place(int value) {
        this.value=value;
    }

    public int getValue(){
        return value;
    }
}
