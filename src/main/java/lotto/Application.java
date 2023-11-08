package lotto;

import java.util.List;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = LottoController.getInstance();
        LottoService lottoService = LottoService.getInstance();

        final int amount = lottoController.getUserInputForAmount();
        final List<Lotto> lottos = lottoService.purchaseLottos(amount);
        OutputView.printLottos(lottos.size(), lottos);

        final List<Integer> winningNumbers = lottoController.getUserInputForWinningNumbers();
        final int bonusNumber = lottoController.getUserInputForBonusNumber(winningNumbers);

        LottoStatistics statistics = new LottoStatistics(lottos, winningNumbers, bonusNumber);
        OutputView.presentResults(statistics.getWinningResult(), statistics.getTotalRate());

    }
}
