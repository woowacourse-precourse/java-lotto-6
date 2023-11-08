package lotto.domain;

public enum LottoHandler {

    OTHER(0, "", 0),
    THREE(3, "", 5000),
    FOUR(4, "", 50000),
    FIVE(5, "", 1500000),
    FIVE_WITH_BONUS(5, ", 보너스 볼 일치", 30000000),
    SIX(6, "", 2000000000);

    private final int count;
    private final String message;
    private final int prize;

    LottoHandler(int count, String message, int prize) {
        this.count = count;
        this.message = message;
        this.prize = prize;
    }

    public static LottoHandler getLottoHandler(int matchingCount) {
        for (LottoHandler lottoHandler : LottoHandler.values()) {
            if (lottoHandler.getCount() == matchingCount) {
                return lottoHandler;
            }
        }

        return OTHER;
    }

    public int getCount() {
        return count;
    }

    public String getMessage() {
        return message;
    }

    public int getPrize() {
        return prize;
    }
}
