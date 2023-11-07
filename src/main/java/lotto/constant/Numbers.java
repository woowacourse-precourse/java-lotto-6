package lotto.constant;

public enum Numbers {
    LOTTOPRICE(1000L),
    NUMBERSPERLOTTO(6L),
    LOTTONUMBERSTART(1L),
    LOTTONUMBEREND(45L),
    FIRSTAWARD(2000000000L),
    SECONDAWARD(30000000L),
    THIRDAWARD(1500000L),
    FOURTHAWARD(50000L),
    FIFTHAWARD(5000L),
    FORPERCENT(100L);

    private final Long value;

    Numbers(Long value) {
        this.value = value;
    }

    public Long getLongValue() {
        return value;
    }

    public Integer getIntValue() {
        return (Integer) value.intValue();
    }
}
