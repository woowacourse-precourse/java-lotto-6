package lotto.constant;

import static lotto.constant.OutputMessage.*;

public enum Prize {
    FIFTH_PRIZE(5000, "(5,000원)", MATCHES_3),
    FOURTH_PRIZE(50_000, "(50,000원)", MATCHES_4),
    THIRD_PRIZE(1_500_000, "(1,500,000원)", MATCHES_5),
    SECOND_PRIZE(30_000_000, "(30,000,000원)", MATCHES_BONUS),
    FIRST_PRIZE(2_000_000_000, "(2,000,000,000원)", MATCHES_6)
    ;
    private final long value;
    private final String number;
    private final OutputMessage outputMessage;

    Prize(long value, String number, OutputMessage outputMessage) {
        this.value = value;
        this.number = number;
        this.outputMessage = outputMessage;

    }

    public long getValue() {
        return value;
    }

    public OutputMessage getOutputMessage() {
        return outputMessage;
    }

    @Override
    public String toString() {
        return this.number;
    }
}
