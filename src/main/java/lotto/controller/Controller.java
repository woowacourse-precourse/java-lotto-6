package lotto.controller;

import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    static final LottoService lottoService = new LottoService();

    public void run() {
        getBudget();
        getLottos();

    private void getBudget() {
        LottoRepository.setBudget(InputView.inputBudget());
    }

    private void getLottos() {
        lottoService.issueLottos();
        OutputView.printLottos();
    }

    }
}
