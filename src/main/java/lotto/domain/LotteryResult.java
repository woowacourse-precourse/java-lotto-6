package lotto.domain;

public enum LotteryResult {
    EIGHTH(0L, ",0원"),
    SEVENTH(0L, ",0원"),
    SIXTH(0L, ",0원"),
    FIFTH(5_000L, "5,000원"),
    FOURTH(50_000L, "50,000원"),
    THIRD(1_500_000L, "1,500,000원"),
    FIRST(2_000_000_000L, "2,000,000,000원"),
    SECOND(30_000_000L, "30,000,000원");


    private final Long prize;

    private final String convertedPrize;

    LotteryResult(Long prize, String convertedPrize) {
        this.prize = prize;
        this.convertedPrize = convertedPrize;
    }

    public boolean isWinning() {
        return prize != 0;
    }

    public Long getPrize() {
        return prize;
    }

    public String getConvertedPrize() {
        return convertedPrize;
    }

}


