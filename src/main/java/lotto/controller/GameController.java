package lotto.controller;

import lotto.domain.Counter;
import lotto.view.InputView;
import lotto.view.OutputView;



public class GameController {

    public static void start(){
        int userMoney = InputView.inputMoney();
        Counter counter = new Counter();
        int lottoAmount = counter.generateLottoCount(userMoney);
        OutputView outputView = new OutputView();
        outputView.printLottoCount(lottoAmount);
    }

}
