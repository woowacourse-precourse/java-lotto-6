package lotto;

public enum LottoWinningStatus {
    THREE_MATCH(5000, "3개 일치 (5,000원) - "),
    FOUR_MATCH(50000, "4개 일치 (50,000원) - "),
    FIVE_MATCH(1500000, "5개 일치 (1,500,000원) - "),
    FIVE_MATCH_WITH_BONUS(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_MATCH(2000000000, "6개 일치 (2,000,000,000원) - ");

    private final int prize;
    private final String prompt;

    LottoWinningStatus(int prize, String prompt) {
        this.prize = prize;
        this.prompt = prompt;
    }

    public int getPrize() {
        return this.prize;
    }

    public String getPrompt() {
        return this.prompt;
    }
}
