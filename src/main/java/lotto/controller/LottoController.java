package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Winning;
import lotto.utils.Convertor;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Lottos lottos = new Lottos(inputView.requirePurchas());
        outputView.anounceLottos(lottos);

        Winning winning = new Winning(Convertor.winningToList(inputView.requireWinning()));
        winning.setBonusNum(Integer.parseInt(inputView.requireBonus()));

        Map<String, Integer> result = lottos.calculateResult(winning);
        outputView.announceResult(result);
    }
}
