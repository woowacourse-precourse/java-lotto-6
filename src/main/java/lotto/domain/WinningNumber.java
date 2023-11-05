package lotto.domain;

import static lotto.Exception.ExceptionMessage.INVALID_BONUS_NUMBER;

public class WinningNumber {

    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningNumber(Lotto lottoNumber, int bonusNumber) {
        validateContainsBonusNumber(lottoNumber, bonusNumber);
        this.winningNumbers = lottoNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validateContainsBonusNumber(Lotto lottoNumber, int bonusNumber) {
        if (lottoNumber.sortLottoNumber().contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER.getExceptionMessage());
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getTicketRank(Lotto lotto) {
        int matchCount = lotto.getMatchCount(winningNumbers);
        return matchCount;
    }


}
