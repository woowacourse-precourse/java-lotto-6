package domain;

import domain.result.WinningResult;

public class LottoTicket {
    public static final int NO_BONUS_NUMBER = -1;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private Lotto lotto;
    private Integer bonusNumber;

    private LottoTicket(Lotto lotto, Integer bonusNumber) {
        this.lotto = lotto;
        validateBonus(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static LottoTicket normalTicketFrom(Lotto lotto) {
        return new LottoTicket(lotto, NO_BONUS_NUMBER);
    }

    public static LottoTicket bonusTicketOf(Lotto lotto, Integer bonusNumber) {
        return new LottoTicket(lotto, bonusNumber);
    }

    public WinningResult getWinningResult(LottoTicket lottoTicket) {
        return WinningResult.getWinningResult(lottoTicket.getMatchedCount(this.lotto),
                lottoTicket.isMatchBonus(this.bonusNumber));
    }

    public Integer getMatchedCount(Lotto lotto) {
        return lotto.getMatchCount(this.lotto);
    }

    public Boolean isMatchBonus(Integer bonusNumber) {
        if (bonusNumber == NO_BONUS_NUMBER) {
            return false;
        }
        return this.lotto.isMatch(bonusNumber);
    }

    private void validateBonus(Integer bonusNumber) {
        if (bonusNumber == NO_BONUS_NUMBER) {
            return;
        }
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("bonus 번호는, " + MIN_NUMBER + "이상, " + MAX_NUMBER + "이하 여야 합니다!");
        }

        if (this.lotto.isMatch(bonusNumber)) {
            throw new IllegalArgumentException("bonus 번호는 lotto 번호와 중복될 수 없습니다!");
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
