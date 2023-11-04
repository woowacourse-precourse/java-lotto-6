package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public LottoController() {
    }

    public void run() {
        Player player = getPlayer();
        showPlayerLotto(player);
        Prize prize = getPrize(getPrizeLotto());
        showLottoResult(player, prize);
    }

    private Player getPlayer() {
        try {
            return Player.from(InputView.getLottoMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayer();
        }
    }

    private void showPlayerLotto(Player player) {
        OutputView.printPlayerAmount(player.getAmount());
        player.getLotto().forEach(lotto -> OutputView.printPlayerLotto(lotto.toString()));
    }

    private Prize getPrize(Lotto lotto) {
        int bonus = InputView.getLottoBonus();
        try {
            return Prize.of(lotto, bonus);
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

    private void showLottoResult(Player player, Prize prize) {
        OutputView.printPrizeResult();
        Result result = Result.of(player.getLotto(), prize);
        for (Rank rank : Rank.values()) {
            if (!rank.equals(Rank.NONE)) {
                int count = result.getResultCount(rank);
                OutputView.printPrizeLotto(rank.formatMessage(count));
            }
        }
        OutputView.printPrizeRate(result.calculateRate(player.getMoney()));
    }
}