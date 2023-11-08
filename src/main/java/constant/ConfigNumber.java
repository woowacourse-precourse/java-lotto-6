package constant;

public enum ConfigNumber {
    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    NUM_COUNT(6),
    COST(1000);

    private final int value;
    ConfigNumber(int value){
        this.value = value;
    }
    public int getValue() {
        return value;
    }

}
