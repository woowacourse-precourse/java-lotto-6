package lotto.presentation.mapper;

import lotto.application.LottoGameInfo;

public abstract class GameResultMapper {

    public static GameResult.IssuedLottos ofLottos(LottoGameInfo.PurchaseStatus purchaseStatus) {
        return GameResult.IssuedLottos.from(purchaseStatus);
    }

    public static GameResult.WinningStatistic ofGame(LottoGameInfo.MatchResult matchResult) {
        return GameResult.WinningStatistic.from(matchResult);
    }

    public static GameResult.RevenueRate ofGameResult(LottoGameInfo.RevenueInfo revenueInfo) {
        return GameResult.RevenueRate.from(revenueInfo);
    }
}
