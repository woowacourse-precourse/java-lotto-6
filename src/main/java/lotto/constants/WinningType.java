package lotto.constants;

public enum WinningType implements Calculator {
    THREE("3개 일치 (5,000원) - %d개") {
        @Override
        public int calculateProfit(int amount) {
            return 5000 * amount;
        }
    },
    FOUR("4개 일치 (50,000원) - %d개") {
        @Override
        public int calculateProfit(int amount) {
            return 50_000 * amount;
        }
    },
    FIVE("5개 일치 (1,500,000원) - %d개") {
        @Override
        public int calculateProfit(int amount) {
            return 1_500_000 * amount;
        }
    },
    FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개") {
        @Override
        public int calculateProfit(int amount) {
            return 30_000_000 * amount;
        }
    },
    SIX("6개 일치 (2,000,000,000원) - %d개") {
        @Override
        public int calculateProfit(int amount) {
            return 2_000_000_000 * amount;
        }
    };

    private final String message;

    WinningType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
