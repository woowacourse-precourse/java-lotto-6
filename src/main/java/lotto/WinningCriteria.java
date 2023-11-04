package lotto;

public enum WinningCriteria {
    FIRST_PLACE{
        public int apply(int x) {
            return x * 2000000000;
        }
    },
    SECOND_PLACE{
        public int apply(int x) {
            return x * 30000000;
        }
    },
    THIRD_PLACE{
        public int apply(int x) {
            return x * 1500000;
        }
    },
    FOURTH_PLACE{
        public int apply(int x) {
            return x * 50000;
        }
    },
    FIFTH_PLACE{
        public int apply(int x) {
            return x * 5000;
        }
    }
}
