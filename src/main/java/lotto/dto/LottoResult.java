package lotto.dto;

public class LottoResult {

    private int rank1;
    private int rank2;
    private int rank3;
    private int rank4;
    private int rank5;

    public static class Builder {
        private int rank1;
        private int rank2;
        private int rank3;
        private int rank4;
        private int rank5;

        public Builder rank1(int rank1) {
            this.rank1 = rank1;
            return this;
        }

        public Builder rank2(int rank2) {
            this.rank2 = rank2;
            return this;
        }

        public Builder rank3(int rank3) {
            this.rank3 = rank3;
            return this;
        }

        public Builder rank4(int rank4) {
            this.rank4 = rank4;
            return this;
        }

        public Builder rank5(int rank5) {
            this.rank5 = rank5;
            return this;
        }

        public LottoResult build() {
            return new LottoResult(this);
        }
    }

    private LottoResult(Builder builder) {
        this.rank1 = builder.rank1;
        this.rank2 = builder.rank2;
        this.rank3 = builder.rank3;
        this.rank4 = builder.rank4;
        this.rank5 = builder.rank5;
    }

    public int getRank1() {
        return rank1;
    }

    public int getRank2() {
        return rank2;
    }

    public int getRank3() {
        return rank3;
    }

    public int getRank4() {
        return rank4;
    }

    public int getRank5() {
        return rank5;
    }
}
