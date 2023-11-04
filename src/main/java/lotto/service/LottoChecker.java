package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.lottoresult.EarningRate;
import lotto.domain.lottoresult.LottoCheckResult;
import lotto.domain.lottoresult.LottoResultStatus;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.lotto.WinningNumbers;

public class LottoChecker {

    public LottoCheckResult checkLottoTickets(LottoTickets lottoTickets, WinningNumbers winningNumbers,
                                              BonusNumber bonusNumber) {
        List<Lotto> tickets = lottoTickets.getLottoTickets();
        LottoCheckResult result = new LottoCheckResult();

        for (Lotto lotto : tickets) {
            LottoResultStatus resultStatus = checkLotto(lotto, winningNumbers, bonusNumber);

            result.updateResult(resultStatus);
        }

        return result;
    }

    public EarningRate calculateEarningRate(LottoCheckResult lottoResult) {
        Map<LottoResultStatus, Integer> result = lottoResult.getResult();
        double numOfTickets = 0;
        double earnedMoney = 0;

        for (Map.Entry<LottoResultStatus, Integer> entry : result.entrySet()) {
            LottoResultStatus status = entry.getKey();
            Integer tickets = entry.getValue();
            int prize = status.getPrize();

            numOfTickets += tickets;
            earnedMoney += prize * tickets;
        }

        return new EarningRate(numOfTickets, earnedMoney);
    }

    private LottoResultStatus checkLotto(Lotto lotto, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        List<Integer> checkLotto = lotto.getLotto();
        List<Integer> winningNum = winningNumbers.getNumbers();
        int bonusNum = bonusNumber.getNumber();

        long matchCount = checkLotto.stream()
                .filter(winningNum::contains)
                .count();

        boolean withBonus = checkLotto.contains(bonusNum);

        return LottoResultStatus.checkResult(matchCount, withBonus);
    }
}
