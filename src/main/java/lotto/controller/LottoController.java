package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.random.RandomGenerator;

public class LottoController {
    public void start() {
        Player player = new Player(InputView.inputCash());
        OutputView.printAttempt(player.getCash());
        player.lottoDraw();
        OutputView.printLotto(player.getLottos());

        Lotto winningLotto = InputView.inputWinningLotto();
        Bonus bonus = InputView.inputBonus(winningLotto);

        List<LottoResult> lottoResults = Comparator.compare(player.getLottos(), winningLotto, bonus);
        OutputLottoResult outputLottoResult = new OutputLottoResult(lottoResults);

        OutputView.printStat(outputLottoResult);
        OutputView.printRateOfReturn(Calculator.calculateRateOfReturn(outputLottoResult.getTotalReturn(), player.getCash()));
    }
}
