package lotto.controller;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.Player;
import lotto.model.lotto.PlayerAmount;
import lotto.model.lotto.Winning;
import lotto.model.result.Prize;
import lotto.model.result.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public LottoController() {
    }

    public void run() {
        Player player = getPlayer();
        showPlayerLotto(player);
        Winning winning = getPrize(getPrizeLotto());
        showLottoResult(player, winning);
    }

    private Player getPlayer() {
        try {
            PlayerAmount playerAmount = PlayerAmount.getInstance(InputView.getLottoMoney());
            return Player.from(playerAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayer();
        }
    }

    private void showPlayerLotto(Player player) {
        OutputView.printPlayerAmount(player.getPlayerAmount());
        player.getPlayerLotto().forEach(lotto -> OutputView.printPlayerLotto(lotto.toString()));
    }

    private Winning getPrize(Lotto lotto) {
        int bonus = InputView.getLottoBonus();
        try {
            return Winning.of(lotto, bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPrize(lotto);
        }
    }

    private Lotto getPrizeLotto() {
        try {
            return new Lotto(InputView.getLottoPrize());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPrizeLotto();
        }
    }

    private void showLottoResult(Player player, Winning winning) {
        OutputView.printPrizeResult();
        Result result = Result.of(player.getPlayerLotto(), winning);
        for (Prize prize : Prize.getPrize()) {
            OutputView.printPrizeLotto(prize.formatMessage(result.getPrizeCount(prize)));
        }
        OutputView.printPrizeRate(result.calculatePrizeProfit(player.getPlayerAmount()));
    }
}