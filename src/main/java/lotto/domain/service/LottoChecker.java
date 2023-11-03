package lotto.domain.service;

import java.util.Collection;
import lotto.domain.LottoCheckResult;
import lotto.domain.WinningStatus;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.lotto.WinningNumbers;

public class LottoChecker {

    public LottoCheckResult checkLottoTickets(LottoTickets lottoTickets, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        Collection<Lotto> tickets = lottoTickets.getLottoTickets();
        LottoCheckResult result = new LottoCheckResult();

        for (Lotto lotto : tickets) {
            WinningStatus checkResult = checkLotto(lotto, winningNumbers, bonusNumber);

            result.updateResult(checkResult);
        }

        return result;
    }

    private WinningStatus checkLotto(Lotto lotto, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        Collection<Integer> checkLotto = lotto.getLotto();
        Collection<Integer> winningNum = winningNumbers.getNumbers();
        int bonusNum = bonusNumber.getNumber();

        long matchCount = checkLotto.stream()
                .filter(winningNum::contains)
                .count();

        boolean withBonus = checkLotto.contains(bonusNum);

        return WinningStatus.getWinningStatus(matchCount, withBonus);
    }
}
