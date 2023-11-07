package lotto.constants;

public class Constants {
    public enum Integers {
        LOTTO_PRICE(1000),
        NOTHING_REMAIN(0),
        ;

        private int value;

        Integers(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum Strings {
        ;

        private String value;

        Strings(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
