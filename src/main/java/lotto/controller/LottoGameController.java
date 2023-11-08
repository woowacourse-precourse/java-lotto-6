package lotto.controller;

import lotto.config.MoneyException;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Player;
import lotto.view.LottoGameView;

import static lotto.service.LottoGameService.*;
import static lotto.view.LottoGameView.inputMoney;


public class LottoGameController {

    public static Lotto winningLotto;
    public static Player player;
    public static int bonusNumber;

    public void startLottoGame(){
        player = new Player();
        player.money = inputPlayerMoney();
        player.lottoTicketNum = player.money / Money.MONEY_UNIT;
        printDisplayPlayerLotto();
        winningLotto = new Lotto( LottoGameView.inputWinningLotto());
        bonusNumber = LottoGameView.inputBonusNumber();
        printDisplayGameResult();
    }
}
