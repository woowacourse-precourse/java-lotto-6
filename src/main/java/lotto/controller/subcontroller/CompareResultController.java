package lotto.controller.subcontroller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.repository.BonusNumberRepository;
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
        inputWinningNumbers();
        compareLottoResult();
        outputLottoResult();
    }

    private void inputWinningNumbers() {
        List<Integer> winnings = inputView.inputWinningNumber();
        WinningLottoRepository.add(new Lotto(winnings));

        int bonus = inputView.inputBonusNumber();
        BonusNumberRepository.add(new BonusNumber(bonus));
    }

    private void compareLottoResult() {
        LottoResultService lottoResultService = new LottoResultService();

        List<Integer> winnings = WinningLottoRepository.findWinningNumbers();
        LottoResult lottoResult = new LottoResult(lottoResultService.compare(winnings));
        LottoResultRepository.add(lottoResult);
    }

    private void outputLottoResult() {
        List<LottoRank> ranks = LottoResultRepository.findLottoRankResults();
        outputView.outputLottoResults(ranks);
    }
}
