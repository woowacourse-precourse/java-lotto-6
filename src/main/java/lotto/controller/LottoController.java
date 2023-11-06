package lotto.controller;

import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(){
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start(){
        Lottos lottos = new Lottos(inputView.readBuyAmount());
        lottos.checkWinningNumbers(parseNumbers(inputView.readWinningNumbers()), inputView.readBonusNumber());
    }


    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
