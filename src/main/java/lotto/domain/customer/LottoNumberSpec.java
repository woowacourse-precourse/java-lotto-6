package lotto.domain.customer;

public enum LottoNumberSpec {
        START_INCLUSIVE(1),
        END_INCLUSIVE(45),
        SIZE(6);

        private final int number;

        LottoNumberSpec(int number) {
                this.number = number;
        }

        public int toInt() {
                return number;
        }
}
