package lotto.domain.dto;

public class StatisticsDto {
    private final int first;
    private final int second;
    private final int third;
    private final int forth;
    private final int fifth;
    private final float ror;

    public StatisticsDto(int first, int second, int third, int forth, int fifth, float ror) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.forth = forth;
        this.fifth = fifth;
        this.ror = ror;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getForth() {
        return forth;
    }

    public int getFifth() {
        return fifth;
    }

    public float getRor() {
        return ror;
    }

    public static class Builder {
        private int first;
        private int second;
        private int third;
        private int forth;
        private int fifth;
        private float ror;

        public Builder first(int first) {
            this.first = first;
            return this;
        }

        public Builder second(int second) {
            this.second = second;
            return this;
        }

        public Builder third(int third) {
            this.third = third;
            return this;
        }

        public Builder forth(int forth) {
            this.forth = forth;
            return this;
        }

        public Builder fifth(int fifth) {
            this.fifth = fifth;
            return this;
        }

        public Builder ror(float ror) {
            this.ror = ror;
            return this;
        }

        public StatisticsDto build() {
            return new StatisticsDto(
                    this.first, this.second, this.third, this.forth, this.fifth, this.ror);
        }
    }
}
