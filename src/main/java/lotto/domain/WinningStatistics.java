package lotto.domain;



public enum WinningStatistics {

    THREE_MATCH(5_000), FOUR_MATCH(50_000), FIVE_MATCH(1_500_000), FIVE_BONUS_MATCH(30_000_000), SIX_MATCH(2_000_000_000);

    private int winningPrize;

    WinningStatistics(int winningPrize) {
        this.winningPrize = winningPrize;
    }

    public int getWinningPrize() {
        return winningPrize;
    }
}
