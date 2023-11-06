package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;

public class LottoController {

    public LottoController() {
    }

    public void start(){
        InputView.printPayAmountInputMessage();
        String lottoPayAmount = Console.readLine();
        // TODO : 로또 구매 기능 인풋 Validate
    }
}
