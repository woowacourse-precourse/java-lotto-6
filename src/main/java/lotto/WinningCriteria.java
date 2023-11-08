package lotto;

public enum WinningCriteria {
    FIRST_PLACE {
        @Override
        public int apply(int count) {
            return count;
        }
    },
    SECOND_PLACE {
        @Override
        public int apply(int count) {
            return count;
        }
    },
    THIRD_PLACE {
        @Override
        public int apply(int count) {
            return count;
        }
    },
    FOURTH_PLACE {
        @Override
        public int apply(int count) {
            return count;
        }
    },
    FIFTH_PLACE {
        @Override
        public int apply(int count) {
            return count;
        }
    };

    public abstract int apply(int count);
}
