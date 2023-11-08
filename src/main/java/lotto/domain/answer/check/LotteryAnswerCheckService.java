package lotto.domain.answer.check;

import java.util.Map;
import lotto.domain.User;
import lotto.domain.answer.LottoAnswer;

public class LotteryAnswerCheckService {
    public Integer getWinningPrice(User user, LottoAnswer lottoAnswer) {
        Map<Integer, Integer> rankToCount = lottoAnswer.getRankToCount(WinningPolicy.getRank, user);
        return WinningMoneyCalculator.calculateWinnigPrice(rankToCount);
    }

}
