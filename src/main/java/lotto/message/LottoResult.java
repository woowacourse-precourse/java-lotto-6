package lotto.message;

public enum LottoResult {
    THREE_NUMBERS_MATCHES("3개 일치 (5,000원) - %d개\n", 5000),
    FOUR_NUMBERS_MATCHES("4개 일치 (50,000원) - %d개\n", 50000),
    FIVE_NUMBERS_MATCHES("5개 일치 (1,500,000원) - %d개\n", 1500000),
    FIVE_AND_BONUS_NUMBERS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", 30000000),
    SIX_NUMBERS_MATCHES("6개 일치 (2,000,000,000원) - %d개\n", 2000000000);

    private final String message;
    private final int price;

    LottoResult(String message, int price) {
        this.message = message;
        this.price = price;
    }

    public static LottoResult getMessageByResult(int matchedNumberCount, boolean isBonusMatched) {
        if (matchedNumberCount == 6) {
            return SIX_NUMBERS_MATCHES;
        }
        if (matchedNumberCount == 5 && isBonusMatched) {
            return FIVE_AND_BONUS_NUMBERS_MATCHES;
        }
        if (matchedNumberCount == 5) {
            return FIVE_NUMBERS_MATCHES;
        }
        if (matchedNumberCount == 4) {
            return FOUR_NUMBERS_MATCHES;
        }
        return THREE_NUMBERS_MATCHES;
    }

    public void print(int count) {
        System.out.printf(message, count);
    }

    public int yield(int count) {
        return this.price * count;
    }
}
