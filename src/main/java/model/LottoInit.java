package model;

public enum LottoInit {

    MINIMUM(1),
    MAXIMUM(45),
    SIZE(6);
    private final int initial;

    LottoInit(int initial) {
        this.initial = initial;
    }

    public int getInitial(){
        return initial;
    }
}
