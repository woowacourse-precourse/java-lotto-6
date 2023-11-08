package lotto.enums;

import java.util.Objects;

public enum ResultStatus {
    NONE0(0, false),
    NONE1(0, false),
    NONE2(0, false),
    MATCH3(5000, false),
    MATCH4(50000, false),
    MATCH5(1500000, false),
    MATCH5_WITH_BONUS_BALL(30000000, true),
    MATCH6(2000000000, false);

    private final int value;
    private final boolean hasBonusBall;

    ResultStatus(int value, boolean hasBonusBall) {
        this.value = value;
        this.hasBonusBall = hasBonusBall;
    }

    public int getValue() {
        return value;
    }

    public boolean getHasBonusBall() {
        return hasBonusBall;
    }

    private static class ResultFlag {
        int count;
        boolean hasBonusBall;

        ResultFlag(int count) {
            this.count = count;
        }

        ResultFlag(int count, boolean hasBonusBall) {
            this.count = count;
            this.hasBonusBall = hasBonusBall;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ResultFlag that = (ResultFlag) o;
            if (that.count == 5) {
                return count == that.count && hasBonusBall == that.hasBonusBall;
            }
            return count == that.count;
        }

        @Override
        public int hashCode() {
            return Objects.hash(count);
        }
    }
}
