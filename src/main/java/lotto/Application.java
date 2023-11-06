package lotto;

import java.util.List;
import lotto.controller.LottoInputController;
import lotto.domain.LottoService;
import lotto.domain.LottoStatistics;
import lotto.view.LottoResultPrinter;

public class Application {
    public static void main(String[] args) {
        LottoInputController inputController = LottoInputController.getInstance();
        LottoService lottoService = LottoService.getInstance();

        int amount = inputController.getUserInputForAmount();
        List<Lotto> lottos = lottoService.purchaseLottos(amount);
        LottoResultPrinter.printLottos(lottos.size(), lottos);

        List<Integer> winningNumbers = inputController.getUserInputForWinningNumbers();
        int bonusNumber = inputController.getUserInputForBonusNumber(winningNumbers);

        LottoStatistics statistics = new LottoStatistics(lottos, winningNumbers, bonusNumber);
        LottoResultPrinter.presentResults(statistics.getWinsPerCategory(), statistics.getTotalRate());
    }
}
