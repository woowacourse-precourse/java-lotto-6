package lotto.util.constants;

public enum OutputConstants {
    ROUNDING_DIGIT(1),
    LOTTO_STATISTICS_MESSAGE("당첨 통계"),
    LINE_SEPARATOR("---"),
    FIFTH_RANK(5, "3개 일치 (5,000원) - %d개") {
        @Override
        public String format(int count) {
            return String.format(getMessage(), count);
        }
    },
    FOURTH_RANK(4, "4개 일치 (50,000원) - %d개") {
        @Override
        public String format(int count) {
            return String.format(getMessage(), count);
        }
    },
    THIRD_RANK(3, "5개 일치 (1,500,000원) - %d개") {
        @Override
        public String format(int count) {
            return String.format(getMessage(), count);
        }
    },
    SECOND_RANK(2, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개") {
        @Override
        public String format(int count) {
            return String.format(getMessage(), count);
        }
    },
    FIRST_RANK(1, "6개 일치 (2,000,000,000원) - %d개") {
        @Override
        public String format(int count) {
            return String.format(getMessage(), count);
        }
    },
    LOTTO_PROFIT_RATIO("총 수익률은 %.1f%%입니다.") {
        @Override
        public String format(double ratio) {
            return String.format(getMessage(), ratio);
        }
    },
    LOTTO_COUNT_MESSAGE("%d개를 구매했습니다.") {
        @Override
        public String format(int count) {
            return String.format(getMessage(), count);
        }
    };

    private final int number;
    private final String message;

    OutputConstants(String message) {
        this.number = 0;
        this.message = message;
    }

    OutputConstants(int number) {
        this.number = number;
        this.message = null;
    }

    OutputConstants(int rank, String message) {
        this.number = rank;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getNumber() {
        return number;
    }

    public String format(int value) {
        return String.valueOf(value);
    }

    public String format(double ratio) {
        return String.valueOf(ratio);
    }

}

