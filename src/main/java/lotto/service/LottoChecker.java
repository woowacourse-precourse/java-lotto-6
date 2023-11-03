package lotto.service;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import lotto.domain.EarningRate;
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

    public EarningRate calculateEarningRate(LottoCheckResult lottoResult) {
        Map<WinningStatus, Integer> result = lottoResult.getResult();
        double numOfTickets = 0;
        double earnedMoney = 0;

        for (Map.Entry<WinningStatus, Integer> entry : result.entrySet()) {
            WinningStatus status = entry.getKey();
            Integer tickets = entry.getValue();

            numOfTickets += tickets;
            earnedMoney += status.getPrize() * tickets;
        }

        return new EarningRate(numOfTickets, earnedMoney);
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
