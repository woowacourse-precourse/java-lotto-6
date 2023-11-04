package lotto.controller;

import java.util.List;
import lotto.model.LottoManager;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    InputView input = new InputView();
    OutputView output = new OutputView();
    LottoManager lotto = new LottoManager();

    public void startGame() {
        String amount = input.getUserBuyAmount();
        int money = Integer.parseInt(amount);

        lotto.buyTickets(money);
        List<String> list = lotto.getTickets();

        output.displayBoughtTickets(list);
    }

}
