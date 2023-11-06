package lotto.controller;

import java.util.List;
import lotto.controller.subcontroller.IssueLottoController;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.repository.BonusNumberRepository;
import lotto.domain.repository.LottoResultRepository;
import lotto.domain.repository.WinningLottoRepository;
import lotto.domain.service.LottoResultService;
import lotto.util.enums.LottoRank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private IssueLottoController issueLottoController;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        initializeControllers();
    }

    private void initializeControllers() {
        issueLottoController = new IssueLottoController(inputView, outputView);
    }

    public void start() {
        issueLottoController.process();
        inputWinningNumbers();
        {
            LottoResultService lottoResultService = new LottoResultService();
            List<Integer> winnings = WinningLottoRepository.findWinningNumbers();
            LottoResult lottoResult = new LottoResult(lottoResultService.compare(winnings));
            LottoResultRepository.add(lottoResult);

            List<LottoRank> ranks = LottoResultRepository.findLottoRankResults();
            outputView.outputLottoResults(ranks);
        }
    }

    private void inputWinningNumbers() {
        List<Integer> winnings = inputView.inputWinningNumber();
        WinningLottoRepository.add(new Lotto(winnings));

        int bonus = inputView.inputBonusNumber();
        BonusNumberRepository.add(new BonusNumber(bonus));
    }
}
