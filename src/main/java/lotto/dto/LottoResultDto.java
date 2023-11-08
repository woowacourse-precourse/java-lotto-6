package lotto.dto;

public class LottoResultDto {
    private int winningCount;
    private boolean hasBonusNumber;

    public LottoResultDto(final int winningCount, final boolean hasBonusNumber) {
        this.winningCount = winningCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static LottoResultDto of(final int winningCount, final boolean hasBonusNumber) {
        return new LottoResultDto(winningCount, hasBonusNumber);
    }

    public int getWinningCount() {
        return this.winningCount;
    }

    public boolean hasBonusNumber() {
        return this.hasBonusNumber;
    }
}
