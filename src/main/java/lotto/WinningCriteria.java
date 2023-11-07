package lotto;

public enum WinningCriteria {
    FIRST_PLACE {
        @Override
        public int apply(int count) {
            return count * 2_000_000_000;
        }
    },
    SECOND_PLACE {
        @Override
        public int apply(int count) {
            return count * 30_000_000;
        }
    },
    THIRD_PLACE {
        @Override
        public int apply(int count) {
            return count * 1_500_000;
        }
    },
    FOURTH_PLACE {
        @Override
        public int apply(int count) {
            return count * 50_000;
        }
    },
    FIFTH_PLACE {
        @Override
        public int apply(int count) {
            return count * 5_000;
        }
    };

    public abstract int apply(int count);
}
