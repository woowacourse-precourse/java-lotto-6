package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.WinningBonusLotto;

public class LottoGame {
    private final LottoMakingController gameSetting = new LottoMakingController();
    private final StatisticsController gameResult = new StatisticsController();
    private Player player;
    private Lotto winningNumber;
    private WinningBonusLotto winningBonusLotto;

    public void start() {
        player = gameSetting.createPlayer();
        player.setLottos(gameSetting.createLottos(player.getPayment()));    //로또 player 게임 셋
        winningNumber = gameSetting.createWinningNumbers();
        winningBonusLotto = gameSetting.createWinningAndBonusLotto(winningNumber);
        player.setWinningBonusLotto(winningBonusLotto);
        gameResult.CountWinningNumber(player);
    }

}
