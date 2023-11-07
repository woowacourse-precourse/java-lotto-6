package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.random.RandomGenerator;

public class LottoController {
    public void start() {
        Player player = new Player();
        inputCash(player);
        
        OutputView.printAttempt(player.getCash());

        drawLotto(player);

        Lotto winningLotto = InputView.inputWinningLotto();
        Bonus bonus = InputView.inputBonus(winningLotto);

        List<LottoResult> lottoResults = Comparator.compare(player.getLottos(), winningLotto, bonus);

        printResult(lottoResults, player);
    }

    private void inputCash(Player player) {
        boolean isRightInput = false;
        while (!isRightInput) {
            try {
                player.setCash(InputView.inputCash());
                isRightInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void drawLotto(Player player) {
        player.drawLotto();
        OutputView.printLotto(player.getLottos());
    }

    private void printResult(List<LottoResult> lottoResults, Player player) {
        OutputLottoResult outputLottoResult = new OutputLottoResult(lottoResults);

        OutputView.printStat(outputLottoResult);
        OutputView.printRateOfReturn(Calculator.calculateRateOfReturn(outputLottoResult.getTotalReturn(), player.getCash()));
    }
}
