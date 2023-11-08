package lotto.constant;

public enum Prize {
    ;
    private final long value;
    private final String number;

    Prize(long value, String number) {
        this.value = value;
        this.number = number;
    }


    @Override
    public String toString() {
        return this.number;
    }
}
