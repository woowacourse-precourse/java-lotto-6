package lotto.controller;

import java.util.List;
import lotto.controller.subcontroller.CompareResultController;
import lotto.controller.subcontroller.IssueLottoController;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Profit;
import lotto.domain.repository.BonusNumberRepository;
import lotto.domain.repository.LottoRepository;
import lotto.domain.repository.LottoResultRepository;
import lotto.domain.repository.ProfitRepository;
import lotto.domain.repository.WinningLottoRepository;
import lotto.domain.service.LottoResultService;
import lotto.domain.service.ProfitService;
import lotto.util.enumerator.LottoRank;
import lotto.util.enumerator.WinningAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private IssueLottoController issueLottoController;
    private CompareResultController compareResultController;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        initializeControllers();
    }

    private void initializeControllers() {
        issueLottoController = new IssueLottoController(inputView, outputView);
        compareResultController = new CompareResultController(inputView, outputView);
    }

    public void start() {
        issueLottoController.process();
        compareResultController.process();
    }


}
