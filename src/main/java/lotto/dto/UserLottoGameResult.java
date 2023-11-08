package lotto.dto;

import java.util.Map;
import lotto.constant.LotteryRankConstant;
import lotto.domain.UserLottoRanks;

public class UserLottoGameResult {
    private final double rateOfReturn;
    private final UserLottoRanks userLottoRanks;

    private UserLottoGameResult(final UserLottoRanks userLottoRanks, final double rateOfReturn) {
        this.userLottoRanks = userLottoRanks;
        this.rateOfReturn = rateOfReturn;
    }

    public static UserLottoGameResult of(final UserLottoRanks userLottoRanks, final double rateOfReturn) {
        return new UserLottoGameResult(userLottoRanks, rateOfReturn);
    }

    public double getRateOfReturn() {
        return this.rateOfReturn;
    }

    public Map<LotteryRankConstant, Integer> getUserLottoRanks() {
        return userLottoRanks.getUserLottoRanks();
    }
}