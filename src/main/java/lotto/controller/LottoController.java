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
        Lottos lottos = new Lottos();
        try {
            lottos.setLottos(inputView.requirePurchas());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            lottos.setLottos(inputView.requirePurchas());
        }
        outputView.anounceLottos(lottos);

        Winning winning = new Winning();
        try {
            winning.setWinning(Convertor.winningToList(inputView.requireWinning()));
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            winning.setWinning(Convertor.winningToList(inputView.requireWinning()));
        }

        try {
            winning.setBonusNum(inputView.requireBonus());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            winning.setBonusNum(inputView.requireBonus());
        }

        Map<String, Integer> result = lottos.calculateResult(winning);
        outputView.announceResult(result);
        outputView.accounceProfit(lottos.calculateProfit(result));
    }
}
