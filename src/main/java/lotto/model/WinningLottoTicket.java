package lotto.model;

public class WinningLottoTicket {

    private final LottoTicket winningNumbers;
    private final int bonusNumber;

    public WinningLottoTicket(LottoTicket winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        validateBonusNumberRange(bonusNumber);
        validateDistinctBonusNumbers(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDistinctBonusNumbers(int bonusNumber) {
        if (winningNumbers.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public int checkNumbers(LottoTicket lottoTicket) {
        return winningNumbers.match(lottoTicket);
    }

    public boolean containsBonusNumber(LottoTicket lottoTicket) {
        return lottoTicket.containsNumber(bonusNumber);
    }
}
