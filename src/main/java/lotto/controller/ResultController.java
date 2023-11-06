package lotto.controller;

import lotto.model.lotto.Player;
import lotto.model.lotto.Winning;
import lotto.model.result.Prize;
import lotto.model.result.Result;
import lotto.view.OutputView;

public class ResultController {
    public Result createResult(Player player, Winning winning) {
        return Result.of(player.getPlayerLotto(), winning);
    }

    public void showResult(Result result, Player player) {
        OutputView.printLottoResult();
        showPrize(result);
        showProfit(result, player);
    }

    private void showPrize(Result result) {
        for (Prize prize : Prize.getPrize()) {
            OutputView.printPrizeMoney(prize.formatMessage(result.getPrizeCount(prize)));
        }
    }

    private void showProfit(Result result, Player player) {
        OutputView.printPrizeProfit(result.calculatePrizeProfit(player.getPlayerAmount()));
    }
}
