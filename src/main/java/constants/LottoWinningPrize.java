package constants;

public enum LottoWinningPrize {

    WINNING_3_PRIZE("5000"),
    WINNING_4_PRIZE("50000"),
    WINNING_5_PRIZE("1500000"),
    WINNING_5_BONUS_PRIZE("30000000"),
    WINNING_6_PRIZE("2000000000");

    private final String prize;

    LottoWinningPrize(String prize){
        this.prize = prize;
    }

    public String getPrize() {
        return prize;
    }
}
