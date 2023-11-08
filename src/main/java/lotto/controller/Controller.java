package lotto.controller;

import java.util.List;
import lotto.domain.DrawingHost;
import lotto.domain.LottoChecker;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    static final LottoService lottoService = new LottoService();

    public void run() {
        getBudget();
        getLottos();
        getResult();
    }

    private void getBudget() {
        LottoRepository.setBudget(InputView.inputBudget());
    }

    private void getLottos() {
        lottoService.issueLottos();
        OutputView.printLottos();
    }

    private void getResult() {
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber(winningNumbers);
        LottoChecker lottoChecker = new LottoChecker(winningNumbers, bonusNumber);
        DrawingHost drawingHost = new DrawingHost(lottoChecker);
        drawingHost.produceResults();
    }
}
