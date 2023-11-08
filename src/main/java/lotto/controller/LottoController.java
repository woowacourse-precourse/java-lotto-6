package lotto.controller;

import java.util.List;
import lotto.domain.LottoCost;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        LottoCost lottoCost = getLottoCost();
        int lottoCount = lottoCost.getLottoCount();
        Lottos lottos = generateLotto(lottoCount);

    }

    private LottoCost getLottoCost() {
        return new LottoCost(InputView.totalCost());
    }

    private Lottos generateLotto(int lottoCount) {
        List<Lotto> lottos = LottoGenerator.generateLottos(lottoCount);
        OutputView.printLottoCount(lottoCount);
        OutputView.printLottos(lottos);
        return new Lottos(lottos);
    }

    private WinningNumber getWinningNumber() {
        List<Integer> winningNumbers = InputView.winningNumber();
        int bonusNumber = InputView.bonusNumber();
        return new WinningNumber(winningNumbers, bonusNumber);
    }
}
