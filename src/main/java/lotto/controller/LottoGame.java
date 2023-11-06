package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private Money money;
    private Lotto lotto; // 당첨 번호
    private Bonus bonus; // 보너스 번호
    private List<Lotto> playerLottos;
    private Result result;

    public void run(){
        start();
        end();
    }

    private void start(){
        money = InputView.LoopInputMoney();
        playerLottos = LottoService.generatePlayerLotto(money);
        // 사용자 로또 출력
        OutputView.printPlayerLotto(playerLottos);
        lotto = InputView.LoopInputSixNumbers();
        bonus = InputView.LoopInputBonusNumber(lotto);
        result = new Result(LottoResult.getResults(lotto, playerLottos, bonus), money);
        // 게임 종료
        end();
    }

    private void end(){

    }
}