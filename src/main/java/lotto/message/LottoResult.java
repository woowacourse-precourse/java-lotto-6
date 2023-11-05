package lotto.message;

public enum LottoResult {
    THREE_NUMBERS_MATCHES("3개 일치 (5,000원) - %d개"),
    FOUR_NUMBERS_MATCHES("4개 일치 (50,000원) - %d개"),
    FIVE_NUMBERS_MATCHES("5개 일치 (1,500,000원) - %d개"),
    FIVE_AND_BONUS_NUMBERS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_NUMBERS_MATCHES("6개 일치 (2,000,000,000원) - %d개");

    private final String message;

    LottoResult(String message) {
        this.message = message;
    }

    public void print(int count) {
        System.out.printf(message, count);
    }

    public String getMessageByResult(int matchedNumberCount, boolean isBonusMatched) {
        if (matchedNumberCount == 6) {
            return SIX_NUMBERS_MATCHES.message;
        }
        if (matchedNumberCount == 5 && isBonusMatched) {
            return FIVE_AND_BONUS_NUMBERS_MATCHES.message;
        }
        if (matchedNumberCount == 5) {
            return FIVE_NUMBERS_MATCHES.message;
        }
        if (matchedNumberCount == 4) {
            return FOUR_NUMBERS_MATCHES.message;
        }
        return THREE_NUMBERS_MATCHES.message;
    }
}
