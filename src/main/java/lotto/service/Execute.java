package lotto.service;

import lotto.console.Input;
import lotto.console.Output;
import lotto.domain.*;

import java.util.List;

public class Execute {
    public static void start(){

        Player player = new Player(Input.askMoney());

        LottoGame lottoGame = new LottoGame(Input.askWinningNum(), Input.askBonusNum());

        LottoMachine.judgeGrade(lottoGame, player);

        Output.printResult(player.getState());

        Output.printRate(player.getAsset());
    }
}
