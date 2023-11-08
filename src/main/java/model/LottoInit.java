package model;

public enum LottoInit {
    LOTTO_MINIMUM(1),
    LOTTO_MAXIMUM(45),
    LOTTO_SIZE(6);
    private final int initial;

    LottoInit(int initial) {
        this.initial = initial;
    }

    public int getInitial() {
        return initial;
    }
}
