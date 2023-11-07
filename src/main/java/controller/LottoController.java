package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Amount;
import view.InputView;

public class LottoController {

    private final InputView inputView;
    private Amount amount;

    public LottoController() {
        inputView = new InputView();
    }

    public void start() {
        RequestLottoAmount();
    }

    private void RequestLottoAmount() {
        inputView.printRequestAmount();
        amount = new Amount(Console.readLine());
    }
}
