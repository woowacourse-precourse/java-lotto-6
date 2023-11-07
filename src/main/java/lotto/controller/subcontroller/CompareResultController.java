package lotto.controller.subcontroller;

import java.util.List;
import lotto.domain.LottoResult;
import lotto.domain.repository.LottoResultRepository;
import lotto.domain.repository.WinningLottoRepository;
import lotto.domain.service.LottoResultService;
import lotto.util.enumerator.LottoRank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class CompareResultController implements Controllable {
    private final InputView inputView;
    private final OutputView outputView;

    public CompareResultController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        compareLottoResult();
        outputLottoResult();
    }

    private void compareLottoResult() {
        LottoResultService lottoResultService = new LottoResultService();

        List<Integer> winnings = WinningLottoRepository.findWinningNumbers().getNumbers();
        LottoResult lottoResult = new LottoResult(lottoResultService.compare(winnings));
        LottoResultRepository.add(lottoResult);
    }

    private void outputLottoResult() {
        List<LottoRank> ranks = LottoResultRepository.findLottoRankResults();
        outputView.outputLottoResults(ranks);
    }
}
