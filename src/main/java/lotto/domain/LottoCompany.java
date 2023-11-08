package lotto.domain;

public class LottoCompany {
    private WinningNumbers winningNumbers;
    private BonusNumbers bonusNumbers;

    private LottoCompany(WinningNumbers winningNumbers, BonusNumbers bonusNumbers) {
        this.winningNumbers = winningNumbers;
        this.bonusNumbers = bonusNumbers;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumbers getBonusNumbers() {
        return bonusNumbers;
    }

    public static LottoCompany createLottoCompany(WinningNumbers winningNumbers, BonusNumbers bonusNumbers) {
        return new LottoCompany(winningNumbers, bonusNumbers);
    }
}
