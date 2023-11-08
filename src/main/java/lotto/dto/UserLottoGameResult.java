package lotto.dto;

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
}