package lotto.controller;

import lotto.domain.Lottos;
import lotto.io.Input;
import lotto.io.Output;

import java.util.List;

public class LottoController {

    public void start() {
        Output output = new Output();
        output.printInputMoneyMessage();

        Input input = new Input();
        int money = input.getMoney();
        Lottos lottos = new Lottos(money);

        output.printInputWinningNumbersMessage();
        List<Integer> winningNumbers = input.getWinningNumbers();

    }
}
