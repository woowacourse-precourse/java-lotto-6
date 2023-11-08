package lotto.domain.ticket;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoResult;

public record WinningTicket(Lotto winningLotto, LottoNumber bonusNumber) {

    public WinningTicket {
        validateWinningTicket(winningLotto, bonusNumber);
    }

    private void validateWinningTicket(final Lotto winningLotto, final LottoNumber bonusNumber) {
        hasBonusNumber(winningLotto, bonusNumber);
    }

    private void hasBonusNumber(final Lotto winningLotto, final LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public LottoResult match(final Lotto lotto) {
        final int countOfMatch = countOfMatch(lotto);
        final boolean hasBonusNumber = hasBonusNumber(lotto);
        return new LottoResult(countOfMatch, hasBonusNumber);
    }

    private int countOfMatch(final Lotto lotto) {
        return (int) lotto.numbers()
                .stream()
                .filter(winningLotto::contains)
                .count();
    }

    private boolean hasBonusNumber(final Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
