package lotto.controller;

import lotto.domain.common.Money;
import lotto.domain.lotto.LottoFactory;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.player.Player;
import lotto.mapper.Mapper;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final LottoMachine lottoMachine;

    public Controller(LottoFactory factory) {
        this.lottoMachine = LottoMachine.from(factory);
    }

    public void run() {
        Player player = createPlayer();
        OutputView.printIssuanceResult(player.showLotto());
    }

    private Player createPlayer() {
        return Player.from(requestPlayerMoney(), lottoMachine);
    }

    private Money requestPlayerMoney() {
        return Mapper.mapToMoney(InputView.readPlayerMoney());
    }
}
