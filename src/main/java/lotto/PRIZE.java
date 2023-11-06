package lotto;

public enum PRIZE {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FORTH(50000),
    FIFTH(5000),
    FAIL(0);

    private final int value;
    PRIZE(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
