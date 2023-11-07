package lotto.domain;

public class LottoGameResult {
    private WinningLottoNumbers winningLottoNumbers;
    private BonusNumber bonusNumber;

    private LottoGameResult(final WinningLottoNumbers winningLottoNumbers, final BonusNumber bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoGameResult of(final WinningLottoNumbers winningLottoNumbers, final BonusNumber bonusNumber) {
        return new LottoGameResult(winningLottoNumbers, bonusNumber);
    }


}