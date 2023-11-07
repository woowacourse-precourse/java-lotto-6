package lotto.domain;

public class LottoResultDto {
    private int winningCount;
    private boolean hasBonusNumber;

    public LottoResultDto(int winningCount, boolean hasBonusNumber) {
        this.winningCount = winningCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public int getWinningCount() {
        return this.winningCount;
    }

    public boolean hasBonusNumber() {
        return this.hasBonusNumber;
    }
}
