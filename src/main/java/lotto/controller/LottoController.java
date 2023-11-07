package lotto.controller;

import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class LottoController {
    private Lottos lottos;
    private InputView inputView;
    private OutputView outputView;

    public LottoController(Lottos lottos, InputView inputView, OutputView outputView) {
        this.lottos = lottos;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        long money = Long.parseLong(inputView.inputMoney());
        String number = inputView.inputNumbers();
        int bonus = Integer.parseInt(inputView.inputBonus());
        List<Integer> numbers = Arrays.stream(number.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

    }
}
