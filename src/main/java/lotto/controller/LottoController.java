package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoChecker;
import lotto.model.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private long money;
    private LottoChecker checker;
    private List<Lotto> lottos;

    public LottoController() {
        buyLotto();
        compareLottos();
        printResult();
    }

    private void buyLotto() {
        money = InputView.getMoney();
        LottoGenerator generator = new LottoGenerator(money);
        lottos = generator.getLottos();

        OutputView.printLottos(lottos);
    }

    private void compareLottos() {
        checker = getWinningLottos();
        checker.checkLottoWithWinningLotto();
    }

    private LottoChecker getWinningLottos() {
        List<Integer> winningLotto = InputView.getWinningLotto();

        return new LottoChecker(lottos, winningLotto, InputView.getBonusLotto(winningLotto));
    }

    private void printResult() {
        OutputView.printResultMessage();

        String profitPercentage = checker.getProfitPercentage(money);
        int[] result = checker.getSameNumberCount();

        OutputView.printCountResult(result);
        OutputView.printTotalPricePercentage(profitPercentage);
    }
}
