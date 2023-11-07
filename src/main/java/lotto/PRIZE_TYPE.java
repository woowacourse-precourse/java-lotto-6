package lotto;

public enum PRIZE_TYPE {
    NONE(0),
    FIVETH(5),
    FOURTH(4),
    THIRD(3),
    SECOND(2),
    FIRST(1);

    PRIZE_TYPE(int value) {
        this.value = value;
    }

    final int value;

}

