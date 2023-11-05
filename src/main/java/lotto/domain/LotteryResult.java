package lotto.domain;

public enum LotteryResult {
    EIGHTH(0, ",0원"),
    SEVENTH(0, ",0원"),
    SIXTH(0, ",0원"),
    FIFTH(5_000, "5,000원"),
    FOURTH(50_000, "50,000원"),
    THIRD(1_500_000, "1,500,000원"),
    FIRST(2_000_000_000, "2,000,000,000원"),
    SECOND(30_000_000, "30,000,000원");


    private final int prize;    //LONG으로 설정해줘야하나 Integer 값 범위를 넘어갔을때를 대비

    private final String convertedPrize;

    LotteryResult(int prize, String convertedPrize) {
        this.prize = prize;
        this.convertedPrize = convertedPrize;
    }

    public boolean isWinning() {
        return prize != 0;
    }
}


