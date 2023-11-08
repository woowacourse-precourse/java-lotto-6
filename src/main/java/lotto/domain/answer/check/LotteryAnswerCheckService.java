package lotto.domain.answer.check;

import java.util.Map;
import lotto.domain.User;
import lotto.domain.answer.LottoAnswer;

public class LotteryAnswerCheckService {
    public Map<Integer, Integer> getRankToCount(User user, LottoAnswer lottoAnswer) {
        return lottoAnswer.getRankToCount(WinningPolicy.getRank, user);
    }

    public Long getWinningPrice(Map<Integer, Integer> rankToCount) {
        return WinningMoneyCalculator.calculateWinnigPrice(rankToCount);
    }

}
