package lotto.controller;

import lotto.domain.Lottos;
import lotto.io.Constants;
import lotto.io.Input;
import lotto.io.Output;

import java.util.List;

public class LottoController {

    final Input input;
    final Output output;

    public LottoController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        output.printInputPurchaseAmountMessage();
        int money = input.getUserAmount();
        int lottoQuantity = money / Constants.LOTTO_PRICE;
        output.printPurchaseQuantity(lottoQuantity);

        Lottos lottos = new Lottos(lottoQuantity);
        List<String> myLottos = lottos.getMyLottos();
        output.printMyLottos(myLottos);

        List<Integer> winningNumbers = input.getWinningNumbers();

    }
}
